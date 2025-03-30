# Dduo-mini-spring - 手写简化版Spring框架

## 🎯 项目目标
1. 通过手写实现深入理解Spring框架核心原理
2. 实现简化版的IoC容器和AOP模块
3. 实践Spring关键模块：
   - Bean生命周期管理
   - 依赖注入（DI）
   - 面向切面编程（AOP）
   - 资源加载与配置解析
   - 事件驱动机制

## 📅 开发路线

![输入图片说明](.idea/image.png)

### 第一阶段：Spring基础概念
- [x] 小试牛刀，实现一个简单的Bean容器 (2025/3/7)


## 🌱 快速开始
```java
// 示例代码位置（可补充...）
MiniApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
UserService userService = (UserService) context.getBean("userService");
userService.sayHello();
```

## 📚 学习资料
- [Spring Framework官方文档]()
- 《Spring源码深度解析》
- 开源项目 https://github.com/fuzhengwei/small-spring

> 注：本计划可根据实际开发进度动态调整，每周同步更新进展说明。欢迎提交PR共同完善！
