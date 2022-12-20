document.writeln("hello javascript!")
document.write("<br/>")
/*
变量名开头可以用 _ $ 和字母
其他部分可以用 $ _ 字母或者数字
 */
var x = 10;
document.writeln("变量x的值:"+x);
//调试日志 console.log
console.log("x="+x);

document.write("<br/>")

var y; //声明了变量x,但是没有赋值
document.writeln('声明了，但是没有赋值的变量 y: '+y);
document.write("<br/>")

//布尔值
var x1=true;
var x2=false;
document.write("布尔值:"+x1);
document.write("<br>");
document.write("布尔值:"+x2);
document.write("<br/>")

var a=10; //十进制
//var b=012;//第一位是0，表示八进制
var c=0xA;//0x开头表示十六进制
var d=3.14;//有小数点表示浮点数
var e=3.14e2;//使用e的幂表示科学计数法
document.write("十进制 10 的值: "+a);
document.write("<br>");
//document.write("八进制 012 的值: "+b);
//document.write("<br>");
document.write("十六进制 0xA 的值: "+c);
document.write("<br>");
document.write("浮点数 3.14 的值: "+d);
document.write("<br>");
document.write("科学记数法 3.14e2 的值: "+e);
document.write("<br>");

//javascript中没有字符的概念，只有字符串，所以单引号和双引号，都用来表示字符串。
var str1='hello'; //单引号
var str2="javascript"; //双引号
document.write("单引号的字符串:"+str1);
document.write("<br>");
document.write("双引号的字符串:"+str2);
document.write("<br>");

document.write("变量str1的类型是:"+(typeof str1));
document.write("<br>");
document.write("变量str1的长度是:"+str1.length);
document.write("<br>");
document.write("数字a可以转换为字符串:"+a.toString());
document.write("<br>");

function print(message){
    document.write(message);
    document.write("<br>");

}
print("第一句话");
print("第二句话");
print("第三句话");

function f1(){
    //函数f1是存在的
}

//js中可以进行异常捕获
try{
    document.write("试图调用不存在的函数f2()<br>");
    f2();  //调用不存在的函数f2();
}
catch(err){
    document.write("捕捉到错误产生:");
    document.write(err.message);
}
document.write("<p>因为错误被捕捉了，所以后续的代码能够继续执行</p>");