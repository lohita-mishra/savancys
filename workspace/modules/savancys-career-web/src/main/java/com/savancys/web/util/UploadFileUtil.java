package com.savancys.web.util;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

@Component(service = UploadFileUtil.class)
public class UploadFileUtil {

	private static final Log log = LogFactoryUtil.getLog(UploadFileUtil.class);

	public long fileUpload(long repositoryId, long companyId, ActionRequest actionRequest, String applicantName,
			File file, String mimeType) {
		String title = applicantName + "_" + System.currentTimeMillis();
		String description = "File uploaded by applicant " + applicantName + " at " + LocalDate.now();
		FileEntry addFileEntry = null;
		try {
			InputStream is = new FileInputStream(file);
			Role adminRole = RoleLocalServiceUtil.getRole(companyId, "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = 0;
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user = UserLocalServiceUtil.getUser(userId);
			PrincipalThreadLocal.setName(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);
			Folder folder = getFolder(repositoryId);
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(repositoryId);
			serviceContext.setUserId(userId);
			addFileEntry = DLAppServiceUtil.addFileEntry(StringPool.BLANK, repositoryId, folder.getFolderId(), title, mimeType,
					title, StringPool.BLANK, description, StringPool.BLANK, is, file.length(), null, null,
					serviceContext);
			 long roleId = RoleLocalServiceUtil.getRole(companyId, "Site Member").getRoleId();
		      HashMap<Long, String[]> roles = (HashMap)new HashMap<>();
		      roles.put(Long.valueOf(roleId), new String[] { "VIEW" });
		      if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(companyId, DLFileEntry.class.getName(), 4, Long.toString(addFileEntry.getFileEntryId()), roleId, "VIEW"))
		          ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, DLFileEntry.class.getName(), 4, Long.toString(addFileEntry.getFileEntryId()), roles); 

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return addFileEntry.getFileEntryId();
	}

	public Folder getFolder(long groupId) {
		Folder folder = null;
		String folderName = "Recruitment";
		try {
			folder = DLAppServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
		} catch (Exception e) {
			log.error(e);
		}
		return folder;
	}

}