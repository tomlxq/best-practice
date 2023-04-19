//webix.codebase = "http://cdn.webix.com/components/konva/";
webix.codebase = "./js/";
webix.protoUI({
    name: "konva",
    $init: function () {
        //creating promise
        this.stage = webix.promise.defer().then(webix.bind(function () {
            //init lib when its ready
            var stage = new Konva.Stage({
                container: this.$view
            });

            //add callback for external code
            if (this.config.ready)
                this.config.ready.call(this, stage);

            return stage;
        }, this));

        //if file already loaded then resolve promise
        if (window.Konva)
            this.stage.resolve();
        else
        //wait for data loading and resolve promise after it
            webix.require("konva/konva.js", function () {
                this.stage.resolve();
            }, this);
    },
    $setSize: function (x, y) {
        if (webix.ui.view.prototype.$setSize.call(this, x, y)) {
            //call resize when lib is ready
            this.stage.then(function (stage) {
                stage.size({width: x, height: y});
            });
        }
    },
    getStage: function () {
        return this.stage;
    }
}, webix.ui.view);