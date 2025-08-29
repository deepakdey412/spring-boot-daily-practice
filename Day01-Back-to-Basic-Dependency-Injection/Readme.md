# Spring Boot Learning Journey

## Day 09 – Dependency Injection in Spring Boot
**Date:** 17-Aug-2025

### What I Learned Today
- Explored **Dependency Injection (DI)** and why it is important in Spring Boot.
- Learned the difference between **Constructor Injection** and **Field Injection**.
- Understood how **Spring IoC (Inversion of Control) Container** manages beans and dependencies.
- Practiced creating services, repositories, and injecting them into controllers using `@Autowired` and constructors.
- Solved common DI issues like `NoSuchBeanDefinitionException`.

### Types of Dependency Injection
1. **Constructor Injection**
   - Dependencies are provided through a class constructor.
   - Preferred for **mandatory dependencies** and easier **unit testing**.

2. **Setter Injection**
   - Dependencies are provided through setter methods.
   - Useful for **optional dependencies**.

3. **Field Injection**
   - Dependencies are injected directly into fields using `@Autowired`.
   - **Not recommended** for production code because it makes testing harder and hides dependencies.

### Resources to Learn Dependency Injection
1. [Spring Official Documentation – Dependency Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans)
2. [Baeldung – Guide to Dependency Injection in Spring](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring)
3. [Java Brains – Spring Framework Tutorials (YouTube)](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa4ad5Jr6TjA36b4k3vNL3t)
4. [Spring Boot Tutorial – Dependency Injection Examples](https://www.springboottutorial.com/spring-boot-dependency-injection)

---

> Day 09: Today I became friends with Spring Boot’s Dependency Injection 🤝
