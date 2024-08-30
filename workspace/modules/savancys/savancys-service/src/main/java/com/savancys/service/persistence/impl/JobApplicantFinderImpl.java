package com.savancys.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.savancys.model.GenericModelMapper;
import com.savancys.model.JobApplicantDTO;
import com.savancys.service.persistence.JobApplicantFinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
@Component(service = JobApplicantFinder.class)
public class JobApplicantFinderImpl extends JobApplicantFinderBaseImpl implements  JobApplicantFinder {
	private static final Log log = LogFactoryUtil.getLog(JobApplicantFinderImpl.class);
	@Reference
	private CustomSQL _customSQL;

	public List<JobApplicantDTO> getJobApplicantDetailsWithJobPostName(Long jobPostId, Date startDate, Date endDate) {
		Session session = null;
		try {
			session = openSession();
			String sql1 = _customSQL.get(getClass(), "fetchCustomJobApplicants");
			StringBuilder sb = new StringBuilder(sql1);
			if (Validator.isNotNull(jobPostId) || Validator.isNotNull(startDate) || Validator.isNotNull(endDate)
					) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
				String startDate1 = startDate != null ? sdf.format(startDate) : "";
				String endDate1 = endDate != null ? sdf.format(endDate) : "";
				boolean hasPreviousCondition = false;
				sb.append(" WHERE ");
				if (jobPostId != 0) {
					sb.append("ja.jobPostId = ").append(jobPostId);
					hasPreviousCondition = true;
				}
				if (!startDate1.isEmpty() || !endDate1.isEmpty()) {
					if (hasPreviousCondition) {
						sb.append(" AND ");
					}
					if (!startDate1.isEmpty() && !endDate1.isEmpty()) {
						sb.append("ja.createDate BETWEEN '").append(startDate1).append("' AND '").append(endDate1)
								.append("'");
					} else if (!startDate1.isEmpty()) {
						sb.append("ja.createDate >= '").append(startDate1).append("'");
					} else if (!endDate1.isEmpty()) {
						sb.append("ja.createDate <= '").append(endDate1).append("'");
					}
					hasPreviousCondition = true;
				}

			}
			sb.append(" ORDER BY ja.createDate DESC");
			SQLQuery query = session.createSQLQuery(sb.toString());
			List<Object[]> results = query.list();
			log.info("results "+results.size());
					
			List<JobApplicantDTO> dtoList = GenericModelMapper.map(JobApplicantDTO.class, results);
			for (JobApplicantDTO jobApplicantDTO : dtoList) {
				System.out.println("jobApplicantDTO"+jobApplicantDTO);
			}
			return dtoList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
}
