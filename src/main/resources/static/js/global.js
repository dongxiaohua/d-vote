$(document).on("click", "ul.nav li.parent > a > span.icon", function () {
    $(this).find('em:first').toggleClass("glyphicon-minus");
});
$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
//自定义 cpu使用率排序
jQuery.fn.dataTableExt.oSort['number-fate-asc'] = function (s1, s2) {
    s1 = s1.replace('%', '');
    s2 = s2.replace('%', '');
    return s1 - s2;
};
jQuery.fn.dataTableExt.oSort['number-fate-desc'] = function (s1, s2) {
    s1 = s1.replace('%', '');
    s2 = s2.replace('%', '');
    return s2 - s1;
};
//自定义 内存排序
jQuery.fn.dataTableExt.oSort['number-m-asc'] = function (s1, s2) {
    s1 = s1.replace('M', '');
    s2 = s2.replace('M', '');
    return s1 - s2;
};
jQuery.fn.dataTableExt.oSort['number-m-desc'] = function (s1, s2) {
    s1 = s1.replace('M', '');
    s2 = s2.replace('M', '');
    return s2 - s1;
};

//自定义 排序
jQuery.fn.dataTableExt.oSort['number-fate-m-asc'] = function (s1, s2) {
    s1 = s1.replace(/%\[.+/g, '');
    s2 = s2.replace(/%\[.+/g, '');
    return s1 - s2;
};
jQuery.fn.dataTableExt.oSort['number-fate-m-desc'] = function (s1, s2) {
    s1 = s1.replace(/%\[.+/g, '');
    s2 = s2.replace(/%\[.+/g, '');
    return s2 - s1;
};

//自定义 带汉字的日期排序
jQuery.fn.dataTableExt.oSort['number-dym-asc'] = function (s1, s2) {
    var arr1 = s1.split(/[天时分]/g);
    var arr2 = s2.split(/[天时分]/g);
    var time1 = arr1[0] * 24 * 60 + arr1[1] * 60 + arr1[2];
    var time2 = arr2[0] * 24 * 60 + arr2[1] * 60 + arr2[2];
    return time1 - time2;
};
jQuery.fn.dataTableExt.oSort['number-dym-desc'] = function (s1, s2) {
    var arr1 = s1.split(/[天时分]/g);
    var arr2 = s2.split(/[天时分]/g);
    var time1 = arr1[0] * 24 * 60 + arr1[1] * 60 + arr1[2];
    var time2 = arr2[0] * 24 * 60 + arr2[1] * 60 + arr2[2];
    return time2 - time1;
};

//自定义 平均负载排序 以1分钟负载（即第一部分）进行排序
jQuery.fn.dataTableExt.oSort['number-load-asc'] = function (s1, s2) {
    var arr1 = s1.split(/,/g);
    var arr2 = s2.split(/,/g);
    var time1 = arr1[0];
    var time2 = arr2[0];
    return time1 - time2;
};
jQuery.fn.dataTableExt.oSort['number-load-desc'] = function (s1, s2) {
    var arr1 = s1.split(/,/g);
    var arr2 = s2.split(/,/g);
    var time1 = arr1[0];
    var time2 = arr2[0];
    return time2 - time1;
};
var bootstrapDom;
var height;
var pageType;
if ($(window).width() < 768) {
    bootstrapDom = "<''<'col-sm-12'f>>" +
        "<''<'col-sm-12'l>>" +
        "<''<'col-sm-12'tr>>" +
        "<''<'col-sm-6'i>>" +
        "<''<p>>";
    height = 0;
    pageType = "simple_numbers";
} else {
    bootstrapDom = "<''<'col-sm-6'l><'col-sm-6'f>>" +
        "<''<'col-sm-12'tr>>" +
        "<''<'col-sm-5'i><'col-sm-7'p>>";
    $("[id^='fix-breadcrumb']").addClass("hide");
    height = $("#navtop").outerHeight();
    pageType = "full_numbers";
    $(function () {
        $("[data-toggle='tooltip']").tooltip()
    });
}
$.extend(true, $.fn.dataTable.defaults, {
    mark: true
});
var AdminLTEOptions = {
    //Add slimscroll to navbar menus
    //This requires you to load the slimscroll plugin
    //in every page before app.js
    navbarMenuSlimscroll: true,
    navbarMenuSlimscrollWidth: "3px", //The width of the scroll bar
    navbarMenuHeight: "200px", //The height of the inner menu
    //General animation speed for JS animated elements such as box collapse/expand and
    //sidebar treeview slide up/down. This options accepts an integer as milliseconds,
    //'fast', 'normal', or 'slow'
    animationSpeed: 500,
    //Sidebar push menu toggle button selector
    sidebarToggleSelector: "[data-toggle='offcanvas']",
    //Activate sidebar push menu
    sidebarPushMenu: true,
    //Activate sidebar slimscroll if the fixed layout is set (requires SlimScroll Plugin)
    sidebarSlimScroll: true,
    //Enable sidebar expand on hover effect for sidebar mini
    //This option is forced to true if both the fixed layout and sidebar mini
    //are used together
    sidebarExpandOnHover: false,
    //BoxRefresh Plugin
    enableBoxRefresh: true,
    //Bootstrap.js tooltip
    enableBSToppltip: true,
    BSTooltipSelector: "[data-toggle='tooltip']",
    //Enable Fast Click. Fastclick.js creates a more
    //native touch experience with touch devices. If you
    //choose to enable the plugin, make sure you load the script
    //before AdminLTE's app.js
    enableFastclick: true,
    //Control Sidebar Options
    enableControlSidebar: true,
    controlSidebarOptions: {
        //Which button should trigger the open/close event
        toggleBtnSelector: "[data-toggle='control-sidebar']",
        //The sidebar selector
        selector: ".control-sidebar",
        //Enable slide over content
        slide: true
    },
    //Box Widget Plugin. Enable this plugin
    //to allow boxes to be collapsed and/or removed
    enableBoxWidget: true,
    //Box Widget plugin options
    boxWidgetOptions: {
        boxWidgetIcons: {
            //Collapse icon
            collapse: 'fa-minus',
            //Open icon
            open: 'fa-plus',
            //Remove icon
            remove: 'fa-times'
        },
        boxWidgetSelectors: {
            //Remove button selector
            remove: '[data-widget="remove"]',
            //Collapse button selector
            collapse: '[data-widget="collapse"]'
        }
    },
    //Direct Chat plugin options
    directChat: {
        //Enable direct chat by default
        enable: true,
        //The button to open and close the chat contacts pane
        contactToggleSelector: '[data-widget="chat-pane-toggle"]'
    },
    //Define the set of colors to use globally around the website
    colors: {
        lightBlue: "#3c8dbc",
        red: "#f56954",
        green: "#00a65a",
        aqua: "#00c0ef",
        yellow: "#f39c12",
        blue: "#0073b7",
        navy: "#001F3F",
        teal: "#39CCCC",
        olive: "#3D9970",
        lime: "#01FF70",
        orange: "#FF851B",
        fuchsia: "#F012BE",
        purple: "#8E24AA",
        maroon: "#D81B60",
        black: "#222222",
        gray: "#d2d6de"
    },
    //The standard screen sizes that bootstrap uses.
    //If you change these in the variables.less file, change
    //them here too.
    screenSizes: {
        xs: 480,
        sm: 768,
        md: 992,
        lg: 1200
    }
};
