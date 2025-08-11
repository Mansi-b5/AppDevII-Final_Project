# 🍕 Pizzeria Android App

## 📌 Introduction
An application where customers can **order pizza and other menu items directly from a Pizzeria**.  
This idea ties in with our **Web Programming III** class project, where we are developing a website for a Pizzeria. We wanted to compare the challenges of building a mobile application versus a website.  
Our app solves the issue of having to use a browser to search for the pizzeria—eliminating competition from other pizza vendors that may appear in search results. The app also provides **push notifications**, making it easier for customers to stay engaged and place orders quickly.  
Through the sections below — **Motivation**, **Environment**, **Navigation**, and **Extra Features** — you will gain a better understanding of our Pizzeria app.

---

## 🎯 Motivation
When searching the web, users are often bombarded with irrelevant results, even for specific queries. For example, searching for *“Pizza Pizza”* brings up **Facebook pages, Twitter accounts, Uber Eats links**, and other competing vendors.  

Creating a **dedicated app** ensures:
- Returning customers can **easily and quickly** place orders without distractions.
- The business builds **brand loyalty**, similar to large companies like Domino’s, McDonald’s, and Pizza Pizza that have embraced mobile apps.
- Notifications directly on the user’s phone can grab attention and encourage frequent purchases.

**Why an app is better than a website:**
- **Faster loading times** since app data is stored locally.
- **Push notifications** for promotions, order updates, and special deals.
- **Always accessible** — one tap from the home screen.

In today’s mobile-first world, most users spend more time on their phones than on laptops. Having a **permanent app icon** increases the likelihood of engagement.

---

## 🌍 Environment
To make the app fully functional, we require the following components:
- **Database** to store:
  - User information (address, name, credit card details)
  - Order history
  - Menu items
- **RecyclerViews** to display:
  - Menu items
  - Cart items
- **Push Notifications** to inform users when their pizza is ready.
- **Fragments** for modular navigation:
  - **Home Fragment** – Welcoming page with navigation options.
  - **Menu Fragment** – Displays available items with add-to-cart functionality.
  - **Cart Fragment** – Shows selected items and total cost.
  - **Checkout Fragment** – Processes orders.
  - **Contact Fragment** – Displays pizzeria location and contact info.
  - **Single Item Fragment** – Shows details for a selected menu item.

---

## 🧩 Fragments

### 🍕 Menu Items Fragment (Mansi)
The goal of this fragment is to **display appealing menu items** to the user.

- **A picture** to visually attract the user.
- **Item name** for clarity.
- **Price** to inform the user upfront.
- **Add-to-cart icon** for quick selection.

The menu will be organized by categories (e.g., pizza, drinks, desserts, pasta) to make browsing easier. When a user adds an item to the cart, they will see a **signal/indicator** confirming the addition and showing the quantity. A dedicated **“View Cart” button** will allow them to check their selections once they’re done browsing.

---

### 🛒 Cart Fragment (David)
The cart fragment shows the user **what they currently have in their cart** and acts as the main link between **order creation and checkout**.

Features include:
- A list of selected items with:
  - Item picture
  - Name
  - Quantity (adjustable)
  - Price per item
- Display of **subtotal and total price**.
- Ability to return to the menu to add more items.
- Checkout button to finalize the order.

An optional feature could be **product recommendations** within the cart to encourage additional purchases.

---

### 📍 Contact/Location Fragment (Bhavik)
The contact/location fragment allows the user to **quickly find and choose** their preferred pizzeria location.

Features include:
- Clickable location selection.
- Click-to-call functionality (opens the phone’s native dialer) *(Extra Feature)*.
- Google Maps integration to navigate to the location *(Extra Feature)*.
- Selected location is displayed as the active choice.

The layout will use a **RecyclerView** for listing multiple locations.

---

### 🏠 Home Fragment (Daniel)
The home fragment is the **first thing the user sees** when opening the app, so it must be **welcoming, user-friendly, and visually appealing**.

Features include:
- **Search bar** to search across all fragments.
- **Text-to-speech** functionality.
- **Deals section** updated weekly.
- **Category shortcuts** that take the user directly to the menu category.
- **Interactive map** showing pizzeria locations and estimated travel times.

This fragment is designed for **quick access** to all features, ensuring the user can place an order or explore the app with minimal effort.

---

## 👥 Team Roles
- **Mansi** – Scrum Master, Website Design, Checkout
- **Michael** – Cart and Order Logic
- **Daniel** – Database, Role-Based Views
- **Phil** – Role-Based Views, Website Design

---
