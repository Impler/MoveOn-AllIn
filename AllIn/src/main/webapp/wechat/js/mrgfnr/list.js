var CURR_PAGE = 0;
mui.init({
	swipeBack : false,
	pullRefresh : {
		container : '#pullrefresh',
		up : {
			contentrefresh : '正在加载...',
			callback : function(){
				mui("#pullInfo")[0].classList.add("mui-hidden");
				getMoreData();
				
			}
		}
	}
});

getMoreData();

function getMoreData() {
	mui.ajax("/AllIn/wechat/mrgfnr.do", {
		dataType : "json",
		data : {
			name : mui("#searchName")[0].value, 
			currentPage : CURR_PAGE + 1
		},
		success : function(xhr) {
			callback(xhr);
		}
	});
}
mui("#addBtn")[0].addEventListener("click", function() {
	window.location.href = '/AllIn/wechat/mrgfnr/new.html';
});

mui("#searchName")[0].addEventListener("keypress", function(e) {
	// 接收回车符
	if (e.keyCode == 13) {
		mui.ajax("/AllIn/wechat/mrgfnr.do", {
			dataType : "json",
			data : {
				name : this.value
			},
			success : function(xhr) {
				if (xhr.code == "0000") {
					mui(".mui-input-group")[0].innerHTML = '';
				}
				callback(xhr);
			}
		});
	}
});
function callback(xhr) {
	if (xhr.code == "0000") {
		var data = xhr.data;
		if(data.length <= 0){
			mui("#pullInfo")[0].innerHTML = "没有更多数据";
		}else{
			CURR_PAGE = xhr.page.currentPage;
			var form = mui(".mui-input-group")[0];
			var htmlStr = "<div class=\"mui-table-view mui-input-row data-row\">"
					+ "		<div class=\"mui-table-view-cell\">"
					+ "			<div class=\"mui-slider-right mui-disabled\">"
					+ "				<a class=\"mui-btn mui-btn-red mui-icon mui-icon-trash data-event\" data-id=\"{0}\"></a>"
					+ "			</div>"
					+ "			<div class=\"mui-slider-handle data-detail\" data-id=\"{0}\">"
					+ "				<div class=\"mui-navigate-right\">"
					+ "					<div class=\"mui-row\">"
					+ "						<div class=\"mui-col-sm-7 mui-col-xs-7\">"
					+ "							<label>{1}</label\">" 
					+ "						</div>"
					+ "						<div class=\"mui-col-sm-4 mui-col-xs-4\">"
					+ "							<label>{2}</label>" 
					+ "						</div>" 
					+ "					</div>"
					+ "				</div>" 
					+ "			</div>" 
					+ "		</div>" 
					+ "	</div>";

			for (var i = 0; i < xhr.data.length; i++) {
				var data = xhr.data[i];
				var html = htmlStr.format(data.id, data.name, data.fee);
				var tmpObj = document.createElement("div");
				tmpObj.innerHTML = html;
				var dom = tmpObj.childNodes[0];
				form.appendChild(dom);
			}
			mui.each(mui(".data-row"), function(index, item) {

				// use HTML5 querySelector API
				var detailTarget = item.querySelector(".data-detail");
				detailTarget.addEventListener("tap", function() {
					var id = this.getAttribute("data-id");
					window.location.href = "/AllIn/wechat/mrgfnr/detail/" + id
							+ ".do";
				});

				var delTarget = item.querySelector(".data-event");
				delTarget.addEventListener("tap", function() {
					var id = this.getAttribute("data-id");
					mui.ajax("/AllIn/wechat/mrgfnr/{0}.do".format(id), {
						dataType : "json",
						type : "delete",
						success : function(xhr) {
							if (xhr.code == "0000") {
								mui.toast("删除成功");
								item.parentNode.removeChild(item);
							} else {
								console.error("errors occur......");
							}
						}
					});
				});
			});
		}
		mui('#pullrefresh').pullRefresh().endPullupToRefresh();
		mui("#pullInfo")[0].classList.remove("mui-hidden");
	} else {
		console.error("errors occur......");
	}
}