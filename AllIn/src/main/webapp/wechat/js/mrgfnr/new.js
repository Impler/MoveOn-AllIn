mui.init();
~function() {
	var form = mui("#mainform")[0];
	var path = window.location.pathname;
	var lastPath = path.substring(path.lastIndexOf("/") + 1);
	var idReg = /(\d+)\.\w/;

	if (idReg.test(lastPath)) {
		var id = RegExp.$1;
		var url = "/AllIn/wechat/mrgfnr/" + id + ".do";
		mui.ajax(url, {
			success : function(xhr) {
				if (xhr.code == "0000") {
					var data = xhr.data;
					var name = data.name;
					mui("#name")[0].value = name;
					mui("#fee")[0].value = data.fee;
					mui("#remark")[0].value = data.remark;
					mui("#date-dpicker")[0].innerHTML = data.formatedDateStr;
					mui("#date")[0].value = data.formatedDateStr;
					var typeId = data.typeId;
					var typeText = gettypeOptions()[typeId - 1].text;
					mui("#type")[0].value = typeId;
					mui("#type-picker")[0].innerHTML = typeText;
				} else {
					alert("error");
				}
			}
		});
		mui("#submitBtn")[0].innerHTML = "修改";
		form.action = "/AllIn/wechat/mrgfnr/" + id + ".do";
		mui("#_method")[0].value = "put";
	}
}();

mui.each(mui(".picker"), function(index, ele) {
	console.log(ele)
	var id = this.getAttribute("id");
	if (/(.*)-([d])?picker/.test(id)) {
		console.log(RegExp.$2);
		var targetId = RegExp.$1;
		var isDatePicker = RegExp.$2 === 'd';

		ele.addEventListener("click", function() {
			var picker;
			var options = eval("get" + targetId + "Options()");
			if (isDatePicker) {
				window.dtPickers = window.dtPickers || [];
				picker = window.dtPickers[targetId];
				if (!picker) {
					options.value = this.innerHTML || '';
					picker = new mui.DtPicker(options);
					window.dtPickers[targetId] = picker;
				}
			} else {
				window.pickers = window.pickers || [];
				picker = window.pickers[targetId];
				if (!picker) {
					picker = new mui.PopPicker();
					picker.setData(options);
					window.pickers[targetId] = picker;
				}
			}
			picker.show(function(selectItems) {
				if (isDatePicker) {
					ele.innerHTML = selectItems.text;
					mui("#" + targetId)[0].value = selectItems.value;
				} else {
					ele.innerHTML = selectItems[0].text;
					mui("#" + targetId)[0].value = selectItems[0].value;
				}
			})
		});
	}
});

function getdateOptions() {
	return {
		type : "date",
		value : ''
	};
}
function gettypeOptions() {
	return [ {
		text : "婚",
		value : "1",
	}, {
		text : "丧",
		value : "2",
	}, {
		text : "生育",
		value : "3",
	} ]
}