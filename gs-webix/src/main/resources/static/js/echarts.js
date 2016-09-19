//webix.codebase = "http://cdn.webix.com/components/konva/";
webix.codebase = "./webjars/echarts/3.2.2/dist/";
webix.protoUI({
    name: "echarts",
    $init: function () {
        //creating promise
        this.chart = webix.promise.defer().then(webix.bind(function () {
            //init lib when its ready
            var chart = echarts.init(this.$view);
            //var stage = new Konva.Stage({
            //    container: this.$view
          //  });

            //add callback for external code
            if (this.config.ready)
                this.config.ready.call(this, chart);

            return chart;
        }, this));

        //if file already loaded then resolve promise
        if (window.echarts)
            this.chart.resolve();
        else
        //wait for data loading and resolve promise after it
            webix.require("echarts.min.js", function () {
                this.chart.resolve();
            }, this);
    },
    $setSize: function (x, y) {
        if (webix.ui.view.prototype.$setSize.call(this, x, y)) {
            //call resize when lib is ready
            this.chart.then(function (chart) {
                chart.size({width: x, height: y});
            });
        }
    },
    getChart: function () {
        return this.chart;
    }
}, webix.ui.view);