(function($) {
    $.fn.select2tree = function(options) {
        var defaults = {
            language: "zh-CN",
            theme: "bootstrap"
        };
        var opts = $.extend(defaults, options);
        opts.templateResult = function(data, container) {
            if(data.element) {
                //insert span element and add 'parent' property
                var $wrapper = $("<span></span><span>" + data.text + "</span>");
                var $element = $(data.element);
                $(container).attr("val", $element.val())
                if($element.attr("parent")) {
                    $(container).attr("parent", $element.attr("parent"));
                }
                return $wrapper;
            } else {
                return data.text;
            }
        };

        $(this).select2(opts).on("select2:open", open);
    };

    function moveOption(id) {
        if(id) {
            $(".select2-results__options li[parent=" + id + "]").insertAfter(".select2-results__options li[val=" + id + "]");
            $(".select2-results__options li[parent=" + id + "]").each(function() {
                moveOption($(this).attr("val"));
            });
        } else {
            $(".select2-results__options li:not([parent])").appendTo(".select2-results__options ul");
            $(".select2-results__options li:not([parent])").each(function() {
                moveOption($(this).attr("val"));
            });
        }
    }

    //deal switch action
    function switchAction(id, open) {
        $(".select2-results__options li[parent='" + id + "']").each(function() {
            switchAction($(this).attr("val"), open);
        });
        //debugger;
        if(open) {
            $(".select2-results__options li[val=" + id + "] span[class]:eq(0)").removeClass("icon-chevron-right").addClass("icon-chevron-down");
            $(".select2-results__options li[parent='" + id + "']").slideDown("slow");
        } else {
            $(".select2-results__options li[val=" + id + "] span[class]:eq(0)").addClass("icon-chevron-right").removeClass("icon-chevron-down");
            $(".select2-results__options li[parent='" + id + "']").slideUp("slow");
        }
    }

    //get the level of li
    function getLevel(id) {
        var level = 0;
        while($(".select2-results__options li[parent][val='" + id + "']").length > 0) {
            id = $(".select2-results__options li[val='" + id + "']").attr("parent");
            level++;
        }
        return level;
    }

    function open() {
        setTimeout(function() {
            moveOption();

            $(".select2-results__options li").each(function() {
                var $this = $(this);
                //loop li add some classes and properties
                if($this.attr("parent")) {
                    $(this).siblings("li[val=" + $this.attr("parent") + "]").find("span:eq(0)").addClass("icon icon-chevron-down switch").css({
                        "padding": "0 5px",
                        "cursor": "default",
                        "display":"inline",
                        "background":"fff",
                    });
                    $(this).siblings("li[val=" + $this.attr("parent") + "]").find("span:eq(1)").css("font-weight", "bold");
                }
                //add gap for children
                if(!$this.attr("style")) {
                    var paddingLeft = getLevel($this.attr("val")) *2.5;
                    $("li[parent='" + $this.attr("parent") + "']").css("padding-left", paddingLeft + "em");
                }
            });

            //override mousedown for collapse/expand
            $(".switch").off("mousedown");
            $(".switch").mousedown(function() {
                //debugger;
                switchAction($(this).parent().attr("val"), $(this).hasClass("icon-chevron-right"));
                event.stopPropagation();
            });

            //override mouseup to nothing
            $(".switch").mouseup(function() {
                return false;
            });
        }, 0);
    }
})(jQuery);
