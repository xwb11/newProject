/***
 *
 * */

;(function ($) {
    'use strict';


    $.adcTable = function (el, options){
        if(!(this instanceof $.adcTable)){
            return new $.adcTable(el, options);
        }

        var self = this;

        self.$container = $(el);

        self.$container.data('adcTable', self);

        // 获取列表数据
        self.getlist = function(type ){
            var option = self.options;
            url = option.myurl+ "/page?pageNo="+option.pageNo+"&pageSize="+option.pageSize + option.searchfn ;
            $.ajax({
                url: option.url ,
                type:"GET",
                success:function (data) {
                    self.getcolumns(data,type);
                }
            });
        };

        self.getcolumns = function () {

        }

        self.init = function () {

            /*if (options.first || options.prev || options.next || options.last || options.page) {
                options = $.extend({}, {
                    first: '',
                    prev: '',
                    next: '',
                    last: '',
                    page: ''
                }, options);
            }
*/

            /* self.extendJquery();

            self.render();

            self.fireEvent(this.options.currentPage, 'init');*/

            self.options = $.extend({}, $.adcTable.defaultOptions, options);

            self.verify();

            self.getlist('init');
        };


        self.verify = function () {
            var opts = self.options;

            if (!self.isNumber(opts.totalPages)) {
                throw new Error('[jqPaginator] type error: totalPages');
            }

            if (!self.isNumber(opts.totalCounts)) {
                throw new Error('[jqPaginator] type error: totalCounts');
            }

            if (!self.isNumber(opts.pageSize)) {
                throw new Error('[jqPaginator] type error: pageSize');
            }

            if (!self.isNumber(opts.currentPage)) {
                throw new Error('[jqPaginator] type error: currentPage');
            }

            if (!self.isNumber(opts.visiblePages)) {
                throw new Error('[jqPaginator] type error: visiblePages');
            }

            if (!opts.totalPages && !opts.totalCounts) {
                throw new Error('[jqPaginator] totalCounts or totalPages is required');
            }

            if (!opts.totalPages && !opts.totalCounts) {
                throw new Error('[jqPaginator] totalCounts or totalPages is required');
            }

            if (!opts.totalPages && opts.totalCounts && !opts.pageSize) {
                throw new Error('[jqPaginator] pageSize is required');
            }

            if (opts.totalCounts && opts.pageSize) {
                opts.totalPages = Math.ceil(opts.totalCounts / opts.pageSize);
            }

            if (opts.currentPage < 1 || opts.currentPage > opts.totalPages) {
                throw new Error('[jqPaginator] currentPage is incorrect');
            }

            if (opts.totalPages < 1) {
                throw new Error('[jqPaginator] totalPages cannot be less currentPage');
            }
        };

        self.isNumber = function (value) {
            var type = typeof value;
            return type === 'number' || type === 'undefined';
        };

        self.callMethod = function (method, options) {
            switch (method) {
                /*case 'option':
                    self.options = $.extend({}, self.options, options);
                    self.verify();
                    self.render();
                    break;
                case 'destroy':
                    self.$container.empty();
                    self.$container.removeData('jqPaginator');
                    break;*/
                default :
                    throw new Error('[jqPaginator] method "' + method + '" does not exist');
            }

            return self.$container;
        };

        self.init();

        return self.$container;

    }

    $.adcTable.defaultOptions = {
        pageSize: 5,
        pageNo: 1,
        totalCounts :  1,
        pagearr : [5,10,15,20],
        myid : '' ,
        myname: '',
        searchmsg:  {},
        url: '',
        myurl:  '',
        columns: {},
        searchfn: '',
        keyid: '',
        checkbox: true,
        numbox: true
    };

    $.fn.adcTable = function () {
        var self = this,
            args = Array.prototype.slice.call(arguments);

        if (typeof args[0] === 'string') {
            var $instance = $(self).data('adcTable');
            if (!$instance) {
                throw new Error('[adcTable] the element is not instantiated');
            } else {
                return $instance.callMethod(args[0], args[1]);
            }
        } else {
            return new $.adcTable(this, args[0]);
        }
    };

})(jQuery);