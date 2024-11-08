<%@ include file="init.jsp"%>

<style>
.refjob-card-sec {
    .refJob-card {
        background: rgba(220, 220, 220, 0.3);
        padding: 1.3rem;
        height: 20rem;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        overflow: hidden;

        * {
            position: relative;
            z-index: 3;
        }

        .code {
            font-size: 1.5rem;
            line-height: normal;
            font-weight: 500;
        }

        a.read-more {
            text-decoration: none !important;

            i {
                background: var(--blue-1);
                width: 3rem;
                height: 3rem;
                color: white;
                display: flex;
                justify-content: center;
                align-items: center;
                border-radius: 10rem;
                font-size: 1rem;
                position: relative;
                transition: 0.3s;

            }

            span {
                font-size: 0.8rem;
                font-weight: 400;
                transition: 0.3s;
            }

            &:hover {

                i {
                    background: var(--green-1);
                }

                span {
                    color: var(--green-1);
                }

            }
        }

    }
     .pagination {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }
        .pagination button {
            padding: 8px 12px;
            margin: 0 5px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }
        .pagination button.disabled {
            background-color: #ddd;
            cursor: not-allowed;
        }
}
</style>

<portlet:renderURL var="addLcaPostingURL">
	<portlet:param name="mvcPath" value="/add_lca_posting.jsp" />
</portlet:renderURL>
<portlet:renderURL var="lcaPostingDetailURL">
	<portlet:param name="mvcRenderCommandName" value="/lcaPostingDetail" />
</portlet:renderURL>

<portlet:resourceURL id="lcaPostings" var="lcaPostingURL"/>

<portlet:resourceURL id="getDesignationAndLocation" var="designationURL" >
	<portlet:param name="getList" value="designation"/>
</portlet:resourceURL>


<portlet:resourceURL id="getDesignationAndLocation" var="locationURL">
	<portlet:param name="getList" value="location"/>
</portlet:resourceURL>

<div class="refjob-card-sec">
	<div class="container">
		<div class="heading">
			<h2>LCA Posting</h2>

			<div class="row mt-3">

				<div class="col-md-4">
					<aui:select id="filterDesignation" name="filterDesignation" label="Choose designation">
						<aui:option>Select</aui:option>
					</aui:select>
				</div>
				<div class="col-md-4">
				    <aui:select name="filterLocation" label="Choose location">
						<aui:option>Select</aui:option>
					</aui:select>
				</div>

				<div class="form-group col-md-4 mt-4 d-flex align-items-end justify-content-between">
					<aui:button type="submit" value="Filter"></aui:button>
					<aui:button href="<%=addLcaPostingURL%>" value="New LCA Posting"></aui:button>
				</div>
			</div>

		</div>

		<div class="row" id="lca-posting-container">
			<!-- cards will be append here -->
		</div>

		<!-- Pagination buttons -->
		<div class="pagination d-flex align-items-center">
			<button id="prev-page" class="disabled">Previous</button>
			<span id="page-info">Page 1</span>
			<button id="next-page">Next</button>
		</div>
	</div>

</div>

<script>

$(document).ready(function () {
	const rowsPerPage = 3;  // Number of cards per page
	let currentPage = 1;    // Keep track of the current page
	let lcaPostingData = [];       // Store the fetched data
	$.ajax({
		type: "GET",
		url: "<%=lcaPostingURL%>",
		contentType: "application/json",
		success: function (response) {
			let cleanedResponse = response.replace(/[\x00-\x1F\x7F]/g, ""); // replace the unstage value
			lcaPostingData = JSON.parse(cleanedResponse);
			renderPage(currentPage);
		}
	});
	function renderPage(page) {
		const start = (page - 1) * rowsPerPage;
		const end = start + rowsPerPage;
		const pageData = lcaPostingData.slice(start, end);
		// Clear the existing lca posting cards
		$('#lca-posting-container').empty();
		pageData.map(function (lcaPosting) {
			const lcaPostingCard = `
					<div class="col-sm-12 col-md-6 col-lg-4 mt-3">
						<div class="refJob-card">
							<div>
								<h6 class="h6 location">`+ lcaPosting.location + `</h6>
								<h3 class="h3 designation">`+ lcaPosting.designation + `</h3>
							</div>
							<div class="d-flex w-100 justify-content-between align-items-end">
								<div>
									<div class="code-name">O-Net Code:</div>
									<div class="code">`+ lcaPosting.oNetCode + `</div>
								</div>
								<div>
									<a href="<%=lcaPostingDetailURL%>&id=` + lcaPosting.lcaPostingId + `" class="read-more d-flex flex-column"> <i
										class="fa-solid fa-arrow-up-right-from-square mb-1"></i> <span>Read
											More</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				`;
			$("#lca-posting-container").append(lcaPostingCard);
		});
		
		// Update page info text
		$('#page-info').text(`Page `+page+` of` +Math.ceil(lcaPostingData.length / rowsPerPage)+``);

		// Enable/Disable the pagination buttons based on the current page
		$('#prev-page').toggleClass('disabled', page === 1);
		$('#next-page').toggleClass('disabled', page === Math.ceil(lcaPostingData.length / rowsPerPage));
	}
	// Handle "Previous" button click
    $('#prev-page').click(function() {
        if (currentPage > 1) {
            currentPage--;
            renderPage(currentPage);
        }
    });

    // Handle "Next" button click
    $('#next-page').click(function() {
        if (currentPage < Math.ceil(lcaPostingData.length / rowsPerPage)) {
            currentPage++;
            renderPage(currentPage);
        }
    });

    function designation(){
    	console.log("designation");
    	$('#<portlet:namespace/>filterDesignation').empty();
    	$("#<portlet:namespace />filterDesignation").append(new Option("Select",""));
    	$.ajax({
    		type: "GET",
    		url: "<%=designationURL%>",
    		contentType: "application/json",
    		success: function (response) {
    			console.log("response");
    			const resp = JSON.parse(response);
    			resp.forEach(function(designation) {
    				console.log(designation);
    				$("#<portlet:namespace/>filterDesignation").append(
    				 new Option(designation, designation));
    			});
    	 	}
    	});
    }
    
   // locationF();
});

function locationF(){
	var designation = $("#<portlet:namespace/>filterDesignation").val();
	$('#<portlet:namespace/>filterLocation').empty();
	$("#<portlet:namespace />filterLocation").append(new Option("Select",""));
	$.ajax({
		type: "GET",
		url: '<%=locationURL %>' + "&<portlet:namespace/>filterDesignation" + designation,
		contentType: "application/json",
		success: function (response) {
			console.log(response);
			$('#<portlet:namespace/>filterLocation').empty();
			const resp = JSON.parse(response);
			resp.forEach(function(location) {
				console.log(location);
				$("#<portlet:namespace/>filterLocation").append(
				 new Option(location, location));
			});
	 	}
	});	
}

</script>
<%-- /* $("#<portlet:namespace/>filterDesignation").change(function() {
	var designation = $("#<portlet:namespace/>filterDesignation").val();
	console.log("clicked" +designation);
	 location(designation);
	
}); */ --%>