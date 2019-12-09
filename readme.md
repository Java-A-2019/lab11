# lab 11

    本节目的：
    1. 理解 Javafx 布局
    2. 熟悉 Javafx 事件处理
    3. 了解 Javafx css 的作用
    4. 以上

**DDL: 2019 年 12 月 15 日**

## Usage
1. 从 github clone 本次 lab
    
        git clone <本次lab url>
2. 使用 Intellij IDEA 打开项目 `lab11-javafx-calculator`

3. 阅读代码，补全代码，实现一个简易计算器

## Description

### 事件
事件 (`Event`) 表示事情的发生，比如鼠标的移动或者是某个按键的按下。在 JavaFX 中，事件是 `javafx.event.Event` 类或其任何子类的实例。JavaFX 提供了多种事件，包括 DragEvent、KeyEvent、MouseEvent、ScrollEvent 等。你可以通过继承 Event 类来实现你自己的事件。

每个事件都有以下信息：

<table>
    <tbody>
        <tr>
            <td width="284"><strong>属性</strong></td>
            <td width="284"><strong>描述</strong></td>
        </tr>
        <tr>
            <td width="284">事件类型(Event type)</td>
            <td width="284">发生事件的类型</td>
        </tr>
        <tr>
            <td width="284">源(Source)</td>
            <td width="284">事件的来源，表示该事件在事件派发链中的位置。事件通过派发链传递时，“源”会随之发生改变。</td>
        </tr>
        <tr>
            <td width="284">目标(Target)</td>
            <td width="284">发生动作的节点，在事件派发链的末尾。“目标”不会改变，但是如果某个事件过滤器在事件捕获阶段消费了该事件，“目标”将不会收到该事件。</td>
        </tr>
    </tbody>
</table>

### 事件处理
事件处理功能由 `Event Filter` 和 `Event Handler` 提供，两者均是 `EventHandler` 接口的实现。如果你想要在某事件发生时通知应用程序，就需要为该事件注册一个 `Event Filter` 或 `Event Handler` 。 `Event Filter` 和 `Event Handler` 之间主要区别在于两者被执行的时机不同。本次 lab 只使用 `Event Handler`

### lambda 表达式

lambda 表达式主要表示实现了 `functional interface` 的实例（具有一个抽象方法的接口称为 `functional interface`。）。 

lambda 表达式实现抽象函数，因此实现了 `functional interface`。 

lambda 表达式在Java 8中添加并提供以下功能：
- 可将函数视为方法参数。
- 可以创建不属于任何类的函数。 
- 可以将 lambda 表达式像对象传递并按需执行。

![img](https://media.geeksforgeeks.org/wp-content/uploads/lambda-expression.jpg)

语法：
    
    lambda operator -> body

- 无参

        () -> System.out.println("Zero parameter lambda");
- 单参数

        (p) -> System.out.println("One parameter: " + p);
- 多参数

        (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);

> note: lambda expressions are just like functions and they accept parameters just like functions.

**我们可以使用 lambda 表达式简化事件处理代码的编写**

看以下代码
```java
Button btn = new Button("Hello world");
btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        System.out.println("Hello World");
    }
});
```

使用 lambda 表达式
```java
Button btn = new Button("Hello world");
btn.setOnAction(event -> {
    System.out.println("Hello World");
});
```

> note: lambda expression is not Object, while `new EventHandler<ActionEvent>() {...}` (Anonymous Class Object) is Object.

**使用 lambda 表达式引用方法**

如何使用 lambda 表达式表示以下代码？
```java
Button btn = new Button("Hello world");
btn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        handleButtonAction();
    }
});
...
handleButtonAction() {
    System.out.println("Hello World");
}
```

使用 lambda 表达式
```java
Button btn = new Button("Hello world");
btn.setOnAction(event -> handleButtonAction());
...
handleButtonAction() {
    System.out.println("Hello World");
}
```

上方 lambda 表达式可以使用 [方法引用](https://www.zhihu.com/question/28565691/answer/192332183) 语法糖简化

你可以认为 方法引用 格式是以下 lambda 表达式的简化
<table>
  <thead>
    <tr>
      <th>Method reference</th>
      <th>&nbsp;</th>
      <th>Equivalent lambda expression</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code class="java">String::valueOf</code></td>
      <td></td>
      <td><code class="java">x -&gt; String.valueOf(x)</code></td>
    </tr>
    <tr>
      <td><code class="java">Object::toString</code></td>
      <td></td>
      <td><code class="java">x -&gt; x.toString()</code></td>
    </tr>
    <tr>
      <td><code class="java">x::toString</code></td>
      <td></td>
      <td><code class="java">() -&gt; x.toString()</code></td>
    </tr>
    <tr>
      <td><code class="java">ArrayList::<span class="keyword">new</span></code></td>
      <td></td>
      <td><code class="java">() -&gt; <span class="keyword">new</span> ArrayList&lt;&gt;()</code></td>
    </tr>
  </tbody>
</table>