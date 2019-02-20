# EventBusReadRecord
目的：
Read and analyze EventBus resource code , for more deeper understanding, I decide rewrite a  EventBus demo ,from  simplicity to complexity


阅读和分析EventBus的源码，为了能够更深入的理解EventBus,决定写一个EventBus Demo,从简单到复杂实现EventBus的各项功能。

工程中参照的是implementation 'org.greenrobot:eventbus:3.1.1' 版本，源码引入


Ver1.0：

    不考虑Eventbus的线程切换、优先级调度等情况，只是实现注解解析、EventBus 绑定、解除绑定、 POSTING模式的同线程发送消息。 -->已经实现

Ver2.0:

    线程模式调度的参考实现。  -->进行中

