# 🚀 Spring Boot Daily Practice – Day 4

Today marks **Day 4** of my daily Spring Boot learning practice.  
My focus for the day was on **configuring simple view controllers without writing full controller classes**.

## 📌 What I Learned Today
I explored **`WebMvcConfigurer`** and understood how to directly map URLs to view templates (like `home.html`, `hello.html`) without creating separate controller classes.  

This approach:
- Reduces **boilerplate code**.
- Keeps controller classes clean and focused only on **complex business logic**.
- Is useful for **static pages** like Home, About, or Login.

## 🛠 What I Built
I created an **`MvcConfig`** class inside:

This class now maps:
- `/home` → `home.html`
- `/` → `home.html`
- `/hello` → `hello.html`

All these mappings are done **without** explicitly writing any controller method.

## 💡 Key Takeaways
- Learned how **`addViewControllers()`** works.
- Understood when to use **view controllers vs. full controllers**.
- Realized this is great for **quick static page mapping**.

---

📅 **Day 4 Completed** ✅  


