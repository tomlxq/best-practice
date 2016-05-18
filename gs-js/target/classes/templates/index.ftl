<script>
    var name = "The Window";
    var object = {
        name: "My Object",
        getNameFunc: function () {
            return function () {
                return this.name;
            };
        }
    };
    alert(object.getNameFunc()());  //The Window
    /*
        function outerFun() {
            var a = 0;
            function innerFun() {
                a++;
                alert(a);
            }
        }
        innerFun();//.innerFun()的作用域在outerFun()内部,所在outerFun()外部调用它是错误的.
    */
    //改成如下,也就是闭包:
    function outerFun() {
        var a = 0;

        function innerFun() {
            a++;
            alert(a);
        }

        return innerFun;  //注意这里
    }
    var obj = outerFun();
    obj();  //结果为1
    obj();  //结果为2
    var obj2 = outerFun();
    obj2();  //结果为1
    obj2();  //结果为2
</script>　　