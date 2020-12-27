

IntelliJ IDEA 使用心得与常用快捷键

## 黑色主题 Darcula

眼睛舒服，最重要的是酷！
设置方式：FILE--Settings--Edit--Colors&Fonts--Scheme name

4.系统终端
有了这个东西，你就不必频繁地切换窗口了
打开方式：Tools--Open Terminal
快捷键：Alt+F12

5.SSH工具
打开方式：Tools--Start SSH session

6.数据库连接工具
打开方式：View--Tool Windows--Database

7.IDEA talk
神奇的东西，你可以联系局域网内其它的IDEA使用者，可以方便地把你的代码show给你的同事
打开方式：View--Tool Windows--IDEA talk

8.Changes
非常方便的changes视图，它会变色显示你所有改动过的文件，而且可以方便的与 本地历史 或 线上历史 做对比
打开方式：View--Tool Windows--Changes

还有git、github、cvs、groovy consle以及等等，真没有的你还可以：
FILE--Settings--Plugins

四. 强大的绘图工具

读源码看不懂项目结构？写文章画类图好麻烦？
右键diagram帮助你

ctrl+shift+alt+u

## 一.找文件找代码找引用相关

1.双击shift
 在项目的所有目录查找，就是你想看到你不想看到的和你没想过你能看到的都给你找出来

2.ctrl+f
当前文件查找特定内容

3.ctrl+shift+f
当前项目查找包含特定内容的文件

4.ctrl+n
查找类

5.ctrl+shift+n
查找文件

6.ctrl+e
最近的文件

7.alt+F7
非常非常频繁使用的一个快捷键，可以帮你找到你的函数或者变量或者类的所有引用到的地方

## 二.编辑相关

1. shift+enter
   另起一行

2. ctrl+r
   当前文件替换特定内容

3. ctrl+shift+r
   当前项目替换特定内容

4. shift+F6
   非常非常省心省力的一个快捷键，可以重命名你的类、方法、变量等等，而且这个重命名甚至可以选择替换掉注释中的内容

5. ctrl+d
   复制当前行到下一行

6. ctrl+x
   剪切当前行

7. ctrl+c \ ctrl+v 
   大家都懂的

8. ctrl+z
   撤销

9. ctrl+shift+z
   取消撤销

10. ctrl+k
    提交代码到SVN

11. ctrl+t
    更新代码

12. alt+insert

13. alt+enter

14. 14.ctrl+alt+L

    自动格式化代码

    个性化设置你自己的代码风格：File--Settings--CodeStyle

## Issuers

###  Serializable接口实现类怎么自动生成serialVersion

`Setting->Inspections->Serialization issues->Serializable class without ’serialVersionUID’ `
