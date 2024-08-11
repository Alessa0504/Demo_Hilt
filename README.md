## 笔记

1. 上层通过@Inject注入User的时候，使用user变量时，@Provides注解方法(即getUser())会自动自动被调用 <br>
2. build代码之后，中间在build包下生成了HiltModule_GetUserFactory这个类

### HiltModule_GetUserFactory 类的生成原理

1. 注解处理器（Annotation Processor）：
   • 在编译时，Hilt 的注解处理器会扫描代码中的 @Module 和 @Provides 注解。 <br>
   • 对于每个带有 @Provides 注解的方法（如 getUser()），Hilt 会生成一个工厂类，用于创建该方法返回的对象。
2. 生成的工厂类：
   • HiltModule_GetUserFactory 是一个实现了 Dagger 的 Factory 接口的类，它提供了创建 User 实例的逻辑。<br>
   • 这个工厂类通过调用 HiltModule.getUser() 方法来创建 User 对象。
3. 代码生成逻辑：
   • Hilt 的注解处理器会生成类似如下的代码：
   ```
    public final class HiltModule_GetUserFactory implements Factory<User> {
        @Override
        public User get() {
            return HiltModule.getUser();
        }

      public static HiltModule_GetUserFactory create() {
        return new HiltModule_GetUserFactory();
    }
   }
   ```
   这个类的 get() 方法会调用 HiltModule.getUser() 方法来生成 User 实例，并将其返回给依赖注入的请求者。

4. 依赖注入流程：
	• 当 Hilt 需要为某个依赖提供 User 对象时，会通过调用 HiltModule_GetUserFactory 类的 get() 方法，间接地调用 HiltModule.getUser()，从而完成依赖注入。
