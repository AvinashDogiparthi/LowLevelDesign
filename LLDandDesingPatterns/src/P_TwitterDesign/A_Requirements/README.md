# 🚀 In-Memory Twitter System

This repository contains the design and implementation of an **In-Memory Twitter System**, designed to handle a lightweight social media platform with ~100 users and ~10,000 tweets. This project is a scalable and efficient implementation of a Twitter-like social media platform, focusing on key functionalities such as tweet management, user interactions, and personalized feeds.

---

## 📌 **Table of Contents**
- [Introduction](#introduction)
- [Problem Statement](#problem-statement)
- [System Design Overview](#system-design-overview)
- [Functional Requirements](#functional-requirements)
- [Non-Functional Requirements & Trade-Offs](#non-functional-requirements--trade-offs)
- [Feed Generation Logic](#feed-generation-logic)
- [Scalability Plan](#scalability-plan)
- [Technologies Used](#technologies-used)

---

## 🚦 **Introduction**
The **In-Memory Twitter System** is a simplified implementation of a social media platform, focusing on efficient tweet management, user interactions, and feed generation. It is designed to efficiently handle the requirements of a small-scale social media platform with low latency and scalable feed management.

---

## 📌 **Problem Statement**
Design an in-memory Twitter system for approximately:
- **100 users**
- **10,000 tweets**

### ✅ **Key Functionalities:**
- Users can **post** and **delete** tweets.
- Users can **follow** and **unfollow** other users.
- Users can view any user’s profile:
    - User ID
    - Followers count
    - Following count
    - Tweets posted
- Users can retrieve a **personalized feed**, which can be sorted based on different criteria.

---

## ⚡ **System Design Overview**
### ✅ **Architecture:**
- **User Management:** Manages user profiles, followers, and following.
- **Tweet Management:** Handles posting, deleting, and viewing tweets.
- **Social Graph:** Manages user connections (follow/unfollow).
- **Feed Generation:** Dynamically generates personalized feeds based on multiple criteria.

### ✅ **Data Structures:**
- **User Map:**
    - Key: User ID
    - Value: User object (followers, following, tweets)
- **Tweet Map:**
    - Key: Tweet ID
    - Value: Tweet object (content, likes, comments, retweets, timestamp)
- **Feed Map:**
    - Key: User ID
    - Value: List of tweets (personalized feed)

### ✅ **Optimized Feed Generation with TreeMap:**
- We use a **TreeMap** (Sorted Map) to generate the feed sorted by most liked tweets.
- TreeMap is chosen because it maintains the sorting order (Descending by likes).
- This ensures efficient feed retrieval based on popularity.

---

## ✅ **Functional Requirements**
### ✅ **User Management:**
- Users can create accounts.
- Users can follow and unfollow other users.
- Users can view any user’s profile, which includes:
    - User ID
    - List of followers
    - List of following
    - Tweets posted by the user.

### ✅ **Tweet Management:**
- Users can post new tweets.
- Users can delete their tweets.

### ✅ **Feed Generation:**
- Users can view their personalized feed.
- The feed can be sorted based on:
    - Content from users they follow.
    - Most liked tweets (Using TreeMap for optimized sorting).
    - Most commented tweets.
    - Most retweeted tweets.

---

## ✅ **Non-Functional Requirements & Trade-Offs**
- **Low Latency:**
    - Follow/unfollow operations have a time complexity of **O(1)** using hash-based sets.
    - Feed generation optimized using TreeMap for most liked posts.
- **Memory Usage:**
    - Optimized for ~100 users and ~10,000 tweets.
    - Suitable for in-memory storage; would scale to distributed storage for higher limits.
- **Scalability:**
    - Designed to be scalable with minimal changes.
    - Can be extended to support millions of users with sharding and caching.

---

## ⚡ **Feed Generation Logic**
This system supports four types of feed generation:
1. **Following Feed:** Tweets from users the current user follows.
2. **Most Liked Feed:** Tweets sorted by the number of likes (using **TreeMap** for efficient sorting).
3. **Most Commented Feed:** Tweets sorted by the number of comments.
4. **Most Retweeted Feed:** Tweets sorted by the number of retweets.

### ✅ **Why TreeMap for Most Liked Feed?**
- TreeMap provides efficient sorting of tweets by likes.
- Time complexity for insertion is **O(log N)**, where **N** is the number of tweets.
- Feeds can be generated in descending order of likes directly.

---

## 🚀 **Scalability Plan**
For a larger user base, this system can be scaled using the following techniques:
- **Sharding:** Partitioning user and tweet data by user-ID range.
- **Distributed Cache (e.g., Redis):** Caching hot timelines to reduce latency.
- **Asynchronous Feed Generation:** Precomputing feeds for heavy users using background jobs.
- **Database Optimization:** Using a distributed database (e.g., Cassandra) for large-scale storage.

---

## 🛠️ **Design Patterns Used**
    - Strategy (for feed sorting).
    - Observer (for follow/unfollow notifications).
    - Singleton (for managing feed service).

