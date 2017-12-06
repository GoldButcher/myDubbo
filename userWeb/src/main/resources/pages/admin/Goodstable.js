var rowNum = 1;
var rooturl = "/campus2/"
var goodtable = $("#goodtable").DataTable({
	"aLengthMenu" : [ 5, 20, 40, 60 ],
	"searching" : false,// 禁用搜索
	"lengthChange" : true,
	"paging" : true,// 开启表格分页
	"bProcessing" : true,
	"bServerSide" : true,
	"bAutoWidth" : false,
	"sort" : "position",
	"deferRender" : false,// 延迟渲染
	"bStateSave" : false, // 在第三页刷新页面，会自动到第一页
	"iDisplayLength" : 5,
	"iDisplayStart" : 0,
	"ordering" : false,// 全局禁用排序
	"ajax" : {
		"type" : "POST",
		"url" : "http://localhost:8080/campus2/goodslist",
		"data" : function(d) {
			d.search = ""
			d.isOrdered = $("select[name=isOrdered]").val();
			d.goodName = "%" + $("input[name=goodname]").val() + "%"
		}
	},
	"aoColumns" : [ {
		"mData" : "goodId",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : "",
		"sWidth" : "10%"
	}, {
		"mData" : "goodName",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : "",
		"sWidth" : "10%"
	}, {
		"mData" : "userName",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : "",
		"sWidth" : "10%"
	}, {
		"mData" : "price",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : "",
		"sWidth" : "10%"
	}, {
		"mData" : "createDate",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : "",
		"sWidth" : "10%",
		"render" : function(data, type, full, meta) {
			// 时间格式化
			return moment(data).format("YYYY-MM-DD HH:mm:ss");
		}
	}, {
		"mData" : "isOrdered",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : "",
		"sWidth" : "10%",
		"render" : function(data, type, full, meta) {

			if (data == 0)
				data = "未成交"
			if (data == 1)
				data = "已成交"
			if (data == 2)
				data = "已取消"
			return data;
		}
	}, {
		"mData" : "goodIntroduction",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : "",
		"sWidth" : "20%"
	}, {
		"mData" : "goodId",
		"orderable" : false, // 禁用排序
		"sDefaultContent" : '',
		"sWidth" : "20%",
		"render" : function(data, type, full, meta) {
			data =  '<button id="deleteOne" onclick="edit(' + data + ')" class="btn btn-success btn-sm" data-id=' + data + '><span class="icon-white icon-edit"></span>detail</button> ';
			return data;

		}
	} ],
	"oLanguage" : { // 国际化配置
		"sProcessing" : "正在获取数据，请稍后...",
		"sLengthMenu" : "显示 _MENU_ 条",
		"sZeroRecords" : "没有找到数据",
		"sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
		"sInfoEmpty" : "记录数为0",
		"sInfoFiltered" : "(全部记录数 _MAX_ 条)",
		"sInfoPostFix" : "",
		"sSearch" : "搜索",
		"sUrl" : "",
		"oPaginate" : {
			"sFirst" : "第一页",
			"sPrevious" : "上一页",
			"sNext" : "下一页",
			"sLast" : "最后一页"
		}
	},
	drawCallback : function() {
		rowNum = 1;
	},
	rowCallback : function(row, data, displayIndex) {
		$('td:eq(0)', row).html($("#goodtable").dataTable().fnSettings()._iDisplayStart + rowNum++);
		return row;
	}
});

$(".search").click(function() {
	goodtable.ajax.reload();
});


