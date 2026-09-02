# Java DSA Prep

_60 problems and concepts for a Java / Spring backend interview, tagged for a **mid-level** bar. Companion to the interactive study guide — same content, offline-friendly._

## How to use this

Read the prompt, work out the approach yourself before reading the given one, then check the code. Difficulty is tagged Easy / Medium / Hard. Every question is **Core** (the fundamentals a mid-level Java/Spring loop expects you to nail) unless marked **Stretch** — those five lean senior/staff; know the idea, but don't burn prep time drilling them to speed. Each question also lists the technique(s) it drills, so you can study by pattern (e.g. every Sliding Window problem) instead of only by data structure.

**Totals:** 55 Core · 5 Stretch

## Contents

1. [Arrays & Strings](#1-arrays-strings) (8)
2. [Linked Lists](#2-linked-lists) (7)
3. [Stacks & Queues](#3-stacks-queues) (6)
4. [Trees & Graphs](#4-trees-graphs) (10)
5. [HashMaps & Sets](#5-hashmaps-sets) (5)
6. [Sorting & Searching](#6-sorting-searching) (6)
7. [Recursion & Dynamic Programming](#7-recursion-dynamic-programming) (6)
8. [Java Internals Q&A](#8-java-internals-qa) (8)
9. [Design-Adjacent Problems](#9-design-adjacent-problems) (4)

---

## 1. Arrays & Strings

> The largest single category in real interviews — most rounds open here as a warm-up.

### Two Sum

`EASY`

**Technique:** Hashing

**Prompt:** Given an array of integers and a target, return the indices of the two numbers that add up to the target.

**Approach:** Walk the array once, storing value → index in a HashMap. Before inserting the current value, check whether target − current already exists in the map.

**Complexity:** Time O(n) · Space O(n)

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int need = target - nums[i];
        if (seen.containsKey(need)) {
            return new int[]{seen.get(need), i};
        }
        seen.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

---

### Three Sum

`MEDIUM`

**Technique:** Two Pointers, Sorting

**Prompt:** Find all unique triplets in an array that sum to zero.

**Approach:** Sort the array, fix one element, then use two pointers on the remainder. Skip over duplicate values at every position to avoid emitting the same triplet twice.

**Complexity:** Time O(n²) · Space O(1) extra

```java
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                lo++; hi--;
            } else if (sum < 0) lo++;
            else hi--;
        }
    }
    return result;
}
```

---

### Maximum Subarray (Kadane's Algorithm)

`MEDIUM`

**Technique:** Dynamic Programming

**Prompt:** Find the contiguous subarray with the largest sum.

**Approach:** Track a running sum. Whenever extending it would be worse than restarting at the current element, restart. Keep a separate best-seen-so-far value.

**Complexity:** Time O(n) · Space O(1)

```java
public int maxSubArray(int[] nums) {
    int best = nums[0], curr = nums[0];
    for (int i = 1; i < nums.length; i++) {
        curr = Math.max(nums[i], curr + nums[i]);
        best = Math.max(best, curr);
    }
    return best;
}
```

---

### Rotate Array

`MEDIUM`

**Technique:** Two Pointers

**Prompt:** Rotate an array to the right by k steps, in place.

**Approach:** Reverse the whole array, then reverse the first k elements and the remaining n−k elements independently. Three reversals produce the rotation without extra storage.

**Complexity:** Time O(n) · Space O(1)

```java
public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
}

private void reverse(int[] a, int lo, int hi) {
    while (lo < hi) {
        int t = a[lo]; a[lo] = a[hi]; a[hi] = t;
        lo++; hi--;
    }
}
```

---

### Merge Intervals

`MEDIUM`

**Technique:** Sorting

**Prompt:** Given a list of [start, end] intervals, merge all overlapping ones.

**Approach:** Sort by start time. Walk through in order, extending the last merged interval whenever the next one starts before (or when) it ends, otherwise starting a new group.

**Complexity:** Time O(n log n) · Space O(n)

```java
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> merged = new ArrayList<>();
    for (int[] curr : intervals) {
        if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < curr[0]) {
            merged.add(curr);
        } else {
            int[] last = merged.get(merged.size() - 1);
            last[1] = Math.max(last[1], curr[1]);
        }
    }
    return merged.toArray(new int[0][]);
}
```

---

### Longest Substring Without Repeating Characters

`MEDIUM`

**Technique:** Sliding Window, Hashing

**Prompt:** Find the length of the longest substring that has no repeated characters.

**Approach:** Sliding window: keep a map of each character's last-seen index. When a repeat is found inside the window, jump the left edge to just past that earlier occurrence.

**Complexity:** Time O(n) · Space O(min(n, alphabet))

```java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> lastSeen = new HashMap<>();
    int maxLen = 0, left = 0;
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
            left = lastSeen.get(c) + 1;
        }
        lastSeen.put(c, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

---

### Valid Anagram

`EASY`

**Technique:** Hashing, String

**Prompt:** Determine whether two strings are anagrams of each other.

**Approach:** Count character frequencies with a fixed-size array (26 letters), incrementing for the first string and decrementing for the second. If every slot returns to zero, they're anagrams.

**Complexity:** Time O(n) · Space O(1)

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counts[s.charAt(i) - 'a']++;
        counts[t.charAt(i) - 'a']--;
    }
    for (int c : counts) if (c != 0) return false;
    return true;
}
```

---

### First Non-Repeating Character

`EASY`

**Technique:** Hashing, String

**Prompt:** Return the index of the first character in a string that does not repeat.

**Approach:** Count every character's frequency in one pass, then scan again in original order and return the first index whose count is exactly 1.

**Complexity:** Time O(n) · Space O(1)

```java
public int firstUniqChar(String s) {
    int[] counts = new int[128];
    for (char c : s.toCharArray()) counts[c]++;
    for (int i = 0; i < s.length(); i++) {
        if (counts[s.charAt(i)] == 1) return i;
    }
    return -1;
}
```

---

## 2. Linked Lists

> Assume this shared node definition for every problem below.

Shared type used by every problem in this section:

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

### Reverse a Linked List

`EASY`

**Technique:** Linked List

**Prompt:** Reverse a singly linked list.

**Approach:** Walk the list once, re-pointing each node's next pointer to the previous node instead of the next one. A recursive version does the same thing by reversing the tail first, then fixing up the current node's links.

**Complexity:** Time O(n) · Space O(1) iterative

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

---

### Detect a Cycle (Floyd's Algorithm)

`EASY`

**Technique:** Linked List, Two Pointers

**Prompt:** Determine whether a linked list contains a cycle.

**Approach:** Move a slow pointer one step and a fast pointer two steps per iteration. If there's a cycle, the fast pointer eventually laps the slow one and they meet.

**Complexity:** Time O(n) · Space O(1)

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

---

### Find the Middle Node

`EASY`

**Technique:** Linked List, Two Pointers

**Prompt:** Return the middle node of a linked list in one pass.

**Approach:** Slow/fast pointer pattern: when fast reaches the end, slow is at the midpoint.

**Complexity:** Time O(n) · Space O(1)

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

---

### Merge Two Sorted Lists

`EASY`

**Technique:** Linked List

**Prompt:** Merge two sorted linked lists into one sorted list.

**Approach:** Use a dummy head and repeatedly attach whichever list's current node is smaller, advancing that list's pointer.

**Complexity:** Time O(n + m) · Space O(1)

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), tail = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { tail.next = l1; l1 = l1.next; }
        else { tail.next = l2; l2 = l2.next; }
        tail = tail.next;
    }
    tail.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

---

### Remove the Nth Node From the End

`MEDIUM`

**Technique:** Linked List, Two Pointers

**Prompt:** Remove the nth node from the end of a linked list in a single pass.

**Approach:** Advance a fast pointer n steps ahead of a slow pointer, then move both together until fast reaches the end — slow now sits just before the node to remove.

**Complexity:** Time O(n) · Space O(1)

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode fast = dummy, slow = dummy;
    for (int i = 0; i < n; i++) fast = fast.next;
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}
```

---

### Detect and Remove a Cycle

`MEDIUM`

**Technique:** Linked List, Two Pointers

**Prompt:** Given a linked list that may contain a cycle, find the cycle's starting node and unlink it.

**Approach:** Find the slow/fast meeting point first. Then reset one pointer to the head and advance both one step at a time — they meet again exactly at the cycle's start. Walk from there to the last node in the cycle and null out its next pointer.

**Complexity:** Time O(n) · Space O(1)

```java
public void detectAndRemoveCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) break;
    }
    if (fast == null || fast.next == null) return; // no cycle

    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    ListNode curr = slow; // start of cycle
    while (curr.next != slow) curr = curr.next;
    curr.next = null;
}
```

---

### Palindrome Linked List

`EASY`

**Technique:** Linked List, Two Pointers

**Prompt:** Check whether a linked list reads the same forwards and backwards.

**Approach:** Find the middle with slow/fast pointers, reverse the second half, then compare it against the first half node by node.

**Complexity:** Time O(n) · Space O(1)

```java
public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode secondHalf = reverseList(slow);
    ListNode p1 = head, p2 = secondHalf;
    while (p2 != null) {
        if (p1.val != p2.val) return false;
        p1 = p1.next;
        p2 = p2.next;
    }
    return true;
}
```

---

## 3. Stacks & Queues

> The LRU cache question below is one of the most commonly asked problems in backend-focused interviews.

### Valid Parentheses

`EASY`

**Technique:** Stack

**Prompt:** Given a string of brackets, determine whether every bracket is properly opened and closed.

**Approach:** Push opening brackets onto a stack. On a closing bracket, pop and check it matches; an empty stack at the end (and never popping an empty one mid-way) means the string is valid.

**Complexity:** Time O(n) · Space O(n)

```java
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
    for (char c : s.toCharArray()) {
        if (pairs.containsValue(c)) {
            stack.push(c);
        } else if (pairs.containsKey(c)) {
            if (stack.isEmpty() || stack.pop() != pairs.get(c)) return false;
        }
    }
    return stack.isEmpty();
}
```

---

### Min Stack

`MEDIUM`

**Technique:** Stack, Design

**Prompt:** Design a stack that supports push, pop, top, and retrieving the minimum element, all in O(1).

**Approach:** Store each value as an offset from the current minimum instead of the raw value. A negative offset signals that pushing that value updated the minimum, so pop can restore the previous minimum from it.

**Complexity:** Time O(1) per op · Space O(n)

```java
class MinStack {
    private final Deque<Long> stack = new ArrayDeque<>();
    private long min;

    public void push(int val) {
        if (stack.isEmpty()) { stack.push(0L); min = val; }
        else {
            stack.push((long) val - min);
            if (val < min) min = val;
        }
    }

    public void pop() {
        long top = stack.pop();
        if (top < 0) min = min - top;
    }

    public int top() {
        long top = stack.peek();
        return (int) (top < 0 ? min : top + min);
    }

    public int getMin() { return (int) min; }
}
```

---

### Implement a Queue Using Two Stacks

`EASY`

**Technique:** Stack, Queue, Design

**Prompt:** Implement a FIFO queue using only two stacks.

**Approach:** Push new elements onto an 'in' stack. When a pop or peek is requested and the 'out' stack is empty, drain the entire 'in' stack into it, which reverses the order back to FIFO.

**Complexity:** Time amortized O(1) · Space O(n)

```java
class MyQueue {
    private final Deque<Integer> inStack = new ArrayDeque<>();
    private final Deque<Integer> outStack = new ArrayDeque<>();

    public void push(int x) { inStack.push(x); }

    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }

    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }

    public boolean empty() { return inStack.isEmpty() && outStack.isEmpty(); }

    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) outStack.push(inStack.pop());
        }
    }
}
```

---

### Next Greater Element

`MEDIUM`

**Technique:** Stack

**Prompt:** For each element in an array, find the next element to its right that is greater than it.

**Approach:** Keep a monotonically decreasing stack of indices. Whenever the current value is greater than the value at the top index, that top index has found its answer — pop and record it.

**Complexity:** Time O(n) · Space O(n)

```java
public int[] nextGreaterElement(int[] nums) {
    int[] result = new int[nums.length];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>(); // holds indices
    for (int i = 0; i < nums.length; i++) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            result[stack.pop()] = nums[i];
        }
        stack.push(i);
    }
    return result;
}
```

---

### Evaluate Reverse Polish Notation

`MEDIUM`

**Technique:** Stack

**Prompt:** Evaluate an arithmetic expression given in postfix (Reverse Polish) notation.

**Approach:** Push numbers onto a stack. On an operator, pop the two most recent operands, apply the operator, and push the result back.

**Complexity:** Time O(n) · Space O(n)

```java
public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
        switch (token) {
            case "+", "-", "*", "/" -> {
                int b = stack.pop(), a = stack.pop();
                stack.push(switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    default -> a / b;
                });
            }
            default -> stack.push(Integer.parseInt(token));
        }
    }
    return stack.pop();
}
```

---

### LRU Cache (via LinkedHashMap)

`MEDIUM`

**Technique:** Hashing, Design

**Prompt:** Design a fixed-capacity cache that evicts the least recently used entry when full.

**Approach:** LinkedHashMap already maintains insertion or access order internally with a doubly linked list. Construct it with accessOrder = true and override removeEldestEntry to evict once size exceeds capacity. See the Design-Adjacent section for the from-scratch version interviewers sometimes ask for instead.

**Complexity:** Time O(1) per op · Space O(capacity)

```java
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // true = access order
        this.capacity = capacity;
    }

    public int get(int key) { return super.getOrDefault(key, -1); }

    public void put(int key, int value) { super.put(key, value); }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
```

---

## 4. Trees & Graphs

> Assume this shared node definition for the tree problems below.

Shared type used by every problem in this section:

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

### Inorder Traversal (Iterative)

`EASY`

**Technique:** Stack, DFS

**Prompt:** Traverse a binary tree inorder without recursion.

**Approach:** Use an explicit stack. Push left children until you hit null, then pop, visit, and move to the right child.

**Complexity:** Time O(n) · Space O(h)

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
    }
    return result;
}
```

---

### Level Order Traversal (BFS)

`MEDIUM`

**Technique:** BFS, Queue

**Prompt:** Return the values of a binary tree grouped by level.

**Approach:** Standard BFS with a queue. Snapshot the queue's size at the start of each level so you know exactly when one level ends and the next begins.

**Complexity:** Time O(n) · Space O(n)

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        result.add(level);
    }
    return result;
}
```

---

### Validate Binary Search Tree

`MEDIUM`

**Technique:** DFS, Recursion

**Prompt:** Check whether a binary tree satisfies the BST property.

**Approach:** Recurse with a valid (min, max) range for each node. Every node must fall strictly inside the range inherited from its ancestors.

**Complexity:** Time O(n) · Space O(h)

```java
public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean validate(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validate(node.left, min, node.val) && validate(node.right, node.val, max);
}
```

---

### Check if a Binary Tree Is Balanced

`MEDIUM`

**Technique:** DFS, Recursion

**Prompt:** Determine whether a binary tree's subtree heights never differ by more than one at any node.

**Approach:** Compute height bottom-up, returning a sentinel (-1) the moment an imbalance is found so the recursion short-circuits instead of recomputing.

**Complexity:** Time O(n) · Space O(h)

```java
public boolean isBalanced(TreeNode root) {
    return height(root) != -1;
}

private int height(TreeNode node) {
    if (node == null) return 0;
    int left = height(node.left);
    if (left == -1) return -1;
    int right = height(node.right);
    if (right == -1) return -1;
    if (Math.abs(left - right) > 1) return -1;
    return Math.max(left, right) + 1;
}
```

---

### Lowest Common Ancestor

`MEDIUM`

**Technique:** DFS, Recursion

**Prompt:** Find the lowest common ancestor of two nodes in a binary tree.

**Approach:** Recurse from the root. If the current node is one of the two targets, return it. Otherwise, if both left and right subtrees report a find, the current node is the LCA; otherwise propagate whichever side found something.

**Complexity:** Time O(n) · Space O(h)

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

---

### Diameter of a Binary Tree

`MEDIUM`

**Technique:** DFS, Recursion

**Prompt:** Find the length of the longest path between any two nodes in a binary tree.

**Approach:** While computing each subtree's depth recursively, track the best left-depth + right-depth seen at any node — that sum is the diameter through that node.

**Complexity:** Time O(n) · Space O(h)

```java
private int diameter = 0;

public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return diameter;
}

private int depth(TreeNode node) {
    if (node == null) return 0;
    int left = depth(node.left);
    int right = depth(node.right);
    diameter = Math.max(diameter, left + right);
    return Math.max(left, right) + 1;
}
```

---

### Serialize and Deserialize a Binary Tree

`HARD · STRETCH`

**Technique:** DFS, Recursion, Design

**Prompt:** Convert a binary tree to a string and back without losing structure.

**Approach:** Preorder-encode the tree, writing a sentinel for null children. Deserializing reads the same tokens in the same order, so the recursive structure rebuilds itself.

**Complexity:** Time O(n) · Space O(n)

```java
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);
    return sb.toString();
}

private void serializeHelper(TreeNode node, StringBuilder sb) {
    if (node == null) { sb.append("#,"); return; }
    sb.append(node.val).append(",");
    serializeHelper(node.left, sb);
    serializeHelper(node.right, sb);
}

public TreeNode deserialize(String data) {
    Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
    return deserializeHelper(nodes);
}

private TreeNode deserializeHelper(Deque<String> nodes) {
    String val = nodes.poll();
    if (val.equals("#")) return null;
    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = deserializeHelper(nodes);
    node.right = deserializeHelper(nodes);
    return node;
}
```

---

### Number of Islands

`MEDIUM`

**Technique:** DFS, Graph

**Prompt:** Given a grid of '1's (land) and '0's (water), count the number of islands.

**Approach:** Scan every cell. On an unvisited land cell, increment the count and flood-fill (DFS or BFS) to sink every connected land cell so it isn't counted again.

**Complexity:** Time O(rows × cols) · Space O(rows × cols) worst case

```java
public int numIslands(char[][] grid) {
    int count = 0;
    for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[r][c] == '1') {
                count++;
                sink(grid, r, c);
            }
        }
    }
    return count;
}

private void sink(char[][] grid, int r, int c) {
    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') return;
    grid[r][c] = '0';
    sink(grid, r + 1, c);
    sink(grid, r - 1, c);
    sink(grid, r, c + 1);
    sink(grid, r, c - 1);
}
```

---

### Detect a Cycle in a Directed Graph

`MEDIUM`

**Technique:** DFS, Graph

**Prompt:** Given a directed graph, determine whether it contains a cycle.

**Approach:** DFS with three states per node: unvisited, currently on the recursion stack ("visiting"), and fully processed. Revisiting a node that's still "visiting" means a back edge, i.e. a cycle.

**Complexity:** Time O(V + E) · Space O(V)

```java
public boolean hasCycle(int n, List<List<Integer>> adj) {
    int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = done
    for (int i = 0; i < n; i++) {
        if (state[i] == 0 && dfs(i, adj, state)) return true;
    }
    return false;
}

private boolean dfs(int node, List<List<Integer>> adj, int[] state) {
    state[node] = 1;
    for (int next : adj.get(node)) {
        if (state[next] == 1) return true;
        if (state[next] == 0 && dfs(next, adj, state)) return true;
    }
    state[node] = 2;
    return false;
}
```

---

### Topological Sort (Kahn's Algorithm)

`MEDIUM`

**Technique:** BFS, Graph

**Prompt:** Produce a valid ordering of a directed acyclic graph's nodes.

**Approach:** Compute the in-degree of every node. Repeatedly remove a node with in-degree zero, add it to the order, and decrement its neighbors' in-degrees. An order shorter than the node count means a cycle exists.

**Complexity:** Time O(V + E) · Space O(V)

```java
public List<Integer> topoSort(int n, List<List<Integer>> adj) {
    int[] indegree = new int[n];
    for (List<Integer> neighbors : adj) {
        for (int v : neighbors) indegree[v]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);

    List<Integer> order = new ArrayList<>();
    while (!queue.isEmpty()) {
        int node = queue.poll();
        order.add(node);
        for (int next : adj.get(node)) {
            if (--indegree[next] == 0) queue.add(next);
        }
    }
    return order.size() == n ? order : List.of(); // empty => cycle
}
```

---

## 5. HashMaps & Sets

### Group Anagrams

`MEDIUM`

**Technique:** Hashing, String

**Prompt:** Group a list of strings so that all anagrams of each other end up together.

**Approach:** Sort the characters of each string to build a canonical key; strings with the same key are anagrams. Group them in a HashMap keyed by that canonical form.

**Complexity:** Time O(n · k log k) · Space O(n · k)

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groups = new HashMap<>();
    for (String s : strs) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(groups.values());
}
```

---

### Subarray Sum Equals K

`MEDIUM`

**Technique:** Hashing, Prefix Sums

**Prompt:** Count the number of contiguous subarrays whose sum equals k.

**Approach:** Track running prefix sums in a HashMap of sum → count seen so far. A subarray summing to k exists ending at index i whenever (prefixSum − k) was seen before.

**Complexity:** Time O(n) · Space O(n)

```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixCounts = new HashMap<>();
    prefixCounts.put(0, 1);
    int sum = 0, count = 0;
    for (int num : nums) {
        sum += num;
        count += prefixCounts.getOrDefault(sum - k, 0);
        prefixCounts.merge(sum, 1, Integer::sum);
    }
    return count;
}
```

---

### Longest Consecutive Sequence

`MEDIUM`

**Technique:** Hashing

**Prompt:** Find the length of the longest run of consecutive integers in an unsorted array.

**Approach:** Put every value in a HashSet. Only start counting from a value that has no predecessor in the set (n − 1 absent) — that guarantees each sequence is walked exactly once.

**Complexity:** Time O(n) · Space O(n)

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);

    int longest = 0;
    for (int n : set) {
        if (!set.contains(n - 1)) {
            int length = 1;
            while (set.contains(n + length)) length++;
            longest = Math.max(longest, length);
        }
    }
    return longest;
}
```

---

### Top K Frequent Elements

`MEDIUM`

**Technique:** Hashing, Heap

**Prompt:** Return the k most frequent elements in an array.

**Approach:** Count frequencies with a HashMap, then keep a min-heap of size k over the keys, ordered by frequency — anything that doesn't make the cut gets evicted.

**Complexity:** Time O(n log k) · Space O(n)

```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) freq.merge(n, 1, Integer::sum);

    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
    for (int key : freq.keySet()) {
        heap.add(key);
        if (heap.size() > k) heap.poll();
    }
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) result[i] = heap.poll();
    return result;
}
```

---

### Design a HashMap From Scratch

`HARD · STRETCH`

**Technique:** Hashing, Design

**Prompt:** Implement a simplified HashMap with put/get, without using java.util.HashMap.

**Approach:** Use an array of buckets, each a chain of entries (separate chaining). Spread the key's hashCode() to compute a bucket index, then walk the chain on collisions. Resize (and rehash) once the load factor is exceeded — this is the same idea Java's real HashMap uses, minus treeification.

**Complexity:** Time O(1) average · Space O(n)

```java
class SimpleHashMap<K, V> {
    private static class Entry<K, V> {
        K key; V value; Entry<K, V> next;
        Entry(K key, V value, Entry<K, V> next) {
            this.key = key; this.value = value; this.next = next;
        }
    }

    private Entry<K, V>[] buckets = new Entry[16];
    private int size = 0;

    public void put(K key, V value) {
        if ((float) size / buckets.length >= 0.75f) resize();
        int idx = indexFor(key);
        for (Entry<K, V> e = buckets[idx]; e != null; e = e.next) {
            if (e.key.equals(key)) { e.value = value; return; }
        }
        buckets[idx] = new Entry<>(key, value, buckets[idx]);
        size++;
    }

    public V get(K key) {
        for (Entry<K, V> e = buckets[indexFor(key)]; e != null; e = e.next) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    private int indexFor(K key) {
        int h = key.hashCode();
        h ^= (h >>> 16);
        return h & (buckets.length - 1);
    }

    private void resize() {
        Entry<K, V>[] old = buckets;
        buckets = new Entry[old.length * 2];
        size = 0;
        for (Entry<K, V> head : old) {
            for (Entry<K, V> e = head; e != null; e = e.next) put(e.key, e.value);
        }
    }
}
```

---

## 6. Sorting & Searching

> Interviewers usually don't need production code here — they want to see you reason about invariants out loud while you write it.

### Binary Search

`EASY`

**Technique:** Binary Search

**Prompt:** Search a sorted array for a target value.

**Approach:** Classic binary search. Watch the boundary conditions (<=, mid computed to avoid overflow) — these are what interviewers probe.

**Complexity:** Time O(log n) · Space O(1)

```java
public int binarySearch(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return -1;
}
```

---

### Search in a Rotated Sorted Array

`MEDIUM`

**Technique:** Binary Search

**Prompt:** Search a target in an array that was sorted, then rotated at an unknown pivot.

**Approach:** At each step, one half of the array (relative to mid) is guaranteed sorted. Check which half is sorted, then decide whether the target lies inside that range or must be in the other half.

**Complexity:** Time O(log n) · Space O(1)

```java
public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return mid;
        if (nums[lo] <= nums[mid]) { // left half sorted
            if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        } else { // right half sorted
            if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
            else hi = mid - 1;
        }
    }
    return -1;
}
```

---

### Quicksort (Implementation)

`MEDIUM`

**Technique:** Sorting

**Prompt:** Implement quicksort in place.

**Approach:** Partition around a pivot (last element here) so everything smaller ends up left of it, then recurse on both sides. Worst case is a bad pivot choice on already-sorted input.

**Complexity:** Time avg O(n log n), worst O(n²) · Space O(log n) recursion

```java
public void quickSort(int[] a, int lo, int hi) {
    if (lo >= hi) return;
    int pivot = a[hi], i = lo;
    for (int j = lo; j < hi; j++) {
        if (a[j] < pivot) { swap(a, i, j); i++; }
    }
    swap(a, i, hi);
    quickSort(a, lo, i - 1);
    quickSort(a, i + 1, hi);
}

private void swap(int[] a, int i, int j) {
    int t = a[i]; a[i] = a[j]; a[j] = t;
}
```

---

### Merge Sort (Implementation)

`MEDIUM`

**Technique:** Sorting

**Prompt:** Implement merge sort.

**Approach:** Split the array in half recursively until segments have one element, then merge sorted halves back together using an auxiliary array.

**Complexity:** Time O(n log n) · Space O(n)

```java
public void mergeSort(int[] a, int lo, int hi) {
    if (lo >= hi) return;
    int mid = lo + (hi - lo) / 2;
    mergeSort(a, lo, mid);
    mergeSort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
}

private void merge(int[] a, int lo, int mid, int hi) {
    int[] tmp = new int[hi - lo + 1];
    int i = lo, j = mid + 1, k = 0;
    while (i <= mid && j <= hi) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
    while (i <= mid) tmp[k++] = a[i++];
    while (j <= hi) tmp[k++] = a[j++];
    System.arraycopy(tmp, 0, a, lo, tmp.length);
}
```

---

### Kth Largest Element

`MEDIUM`

**Technique:** Heap

**Prompt:** Find the kth largest element in an unsorted array.

**Approach:** Maintain a min-heap of size k. Push every element; whenever the heap grows past k, pop the smallest. What remains at the top after processing everything is the kth largest.

**Complexity:** Time O(n log k) · Space O(k)

```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int n : nums) {
        minHeap.add(n);
        if (minHeap.size() > k) minHeap.poll();
    }
    return minHeap.peek();
}
```

---

### Merge K Sorted Lists

`HARD · STRETCH`

**Technique:** Heap, Linked List

**Prompt:** Merge k sorted linked lists into one sorted list.

**Approach:** Put the head of every list into a min-heap ordered by value. Repeatedly pop the smallest, append it to the result, and push its successor (if any) back into the heap.

**Complexity:** Time O(n log k) · Space O(k)

```java
public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) if (node != null) heap.add(node);

    ListNode dummy = new ListNode(0), tail = dummy;
    while (!heap.isEmpty()) {
        ListNode node = heap.poll();
        tail.next = node;
        tail = tail.next;
        if (node.next != null) heap.add(node.next);
    }
    return dummy.next;
}
```

---

## 7. Recursion & Dynamic Programming

> Shows up less often at the junior/mid backend level, but is common at larger product companies.

### Climbing Stairs

`EASY`

**Technique:** Dynamic Programming, Recursion

**Prompt:** Count the number of distinct ways to climb n stairs, taking 1 or 2 steps at a time.

**Approach:** This is just Fibonacci: the ways to reach step n equal the ways to reach n−1 plus the ways to reach n−2. Track only the last two values instead of a full array.

**Complexity:** Time O(n) · Space O(1)

```java
public int climbStairs(int n) {
    if (n <= 2) return n;
    int prev2 = 1, prev1 = 2;
    for (int i = 3; i <= n; i++) {
        int curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
}
```

---

### Coin Change (Minimum Coins)

`MEDIUM`

**Technique:** Dynamic Programming

**Prompt:** Given coin denominations, find the minimum number of coins that add up to a target amount.

**Approach:** Bottom-up DP: dp[i] is the fewest coins to make amount i. For each amount, try every coin no larger than it and take the best result from dp[i - coin] + 1.

**Complexity:** Time O(amount × coins) · Space O(amount)

```java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
```

---

### Longest Common Subsequence

`MEDIUM`

**Technique:** Dynamic Programming

**Prompt:** Find the length of the longest subsequence common to two strings.

**Approach:** Classic 2D DP: dp[i][j] is the LCS length of the first i and j characters. Matching characters extend the diagonal; otherwise take the best of dropping one character from either string.

**Complexity:** Time O(n × m) · Space O(n × m)

```java
public int longestCommonSubsequence(String a, String b) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];
    for (int i = 1; i <= a.length(); i++) {
        for (int j = 1; j <= b.length(); j++) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
            else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[a.length()][b.length()];
}
```

---

### 0/1 Knapsack

`MEDIUM`

**Technique:** Dynamic Programming

**Prompt:** Given item weights and values and a capacity, maximize total value without exceeding capacity, using each item at most once.

**Approach:** dp[i][w] is the best value using the first i items with capacity w. Either skip item i or, if it fits, take it and add its value to the best solution for the remaining capacity.

**Complexity:** Time O(n × capacity) · Space O(n × capacity)

```java
public int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];
    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            dp[i][w] = dp[i - 1][w];
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            }
        }
    }
    return dp[n][capacity];
}
```

---

### Longest Increasing Subsequence

`MEDIUM`

**Technique:** Dynamic Programming, Binary Search

**Prompt:** Find the length of the longest strictly increasing subsequence in an array.

**Approach:** Maintain an array 'tails' where tails[i] is the smallest possible tail value of an increasing subsequence of length i+1. Binary search for where each new number belongs; the final size of tails is the answer.

**Complexity:** Time O(n log n) · Space O(n)

```java
public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int num : nums) {
        int lo = 0, hi = size;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (tails[mid] < num) lo = mid + 1; else hi = mid;
        }
        tails[lo] = num;
        if (lo == size) size++;
    }
    return size;
}
```

---

### Edit Distance

`HARD · STRETCH`

**Technique:** Dynamic Programming

**Prompt:** Find the minimum number of insert/delete/replace operations to turn one string into another.

**Approach:** 2D DP where dp[i][j] is the edit distance between the first i and j characters. Matching characters cost nothing extra; otherwise take the minimum of insert, delete, or replace, plus one.

**Complexity:** Time O(n × m) · Space O(n × m)

```java
public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
    for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

    for (int i = 1; i <= word1.length(); i++) {
        for (int j = 1; j <= word2.length(); j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
            else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        }
    }
    return dp[word1.length()][word2.length()];
}
```

---

## 8. Java Internals Q&A

> Pure DSA questions rarely stand alone in a Java/Spring interview — expect these mixed in as follow-ups to probe whether you understand what's underneath the collections you just used.

### How does HashMap work internally?

`MEDIUM`

**Technique:** Hashing

**Prompt:** Explain HashMap's internal structure in Java 8+.

**Approach:** Backed by an array of buckets (Node<K,V>[] table). The key's hashCode() is spread with (h = key.hashCode()) ^ (h >>> 16) to reduce collisions from poor hash distributions, then the bucket index is hash & (capacity − 1). Collisions chain as a linked list per bucket; once a bucket holds 8+ entries and the table has at least 64 slots, that bucket treeifies into a red-black tree for O(log n) worst case instead of O(n). The table doubles and rehashes once size exceeds capacity × loadFactor (default 0.75).

---

### HashMap vs. TreeMap vs. LinkedHashMap

`EASY`

**Technique:** Hashing

**Prompt:** When would you choose each of Java's three main Map implementations?

**Approach:** HashMap: no ordering guarantee, O(1) average get/put — the default choice. LinkedHashMap: preserves insertion order (or access order, if configured) via an internal doubly linked list, still O(1) average — useful for LRU caches or predictable iteration. TreeMap: keeps keys sorted via a red-black tree, O(log n) get/put — use it when you need sorted iteration or range queries (headMap/tailMap).

---

### ArrayList vs. LinkedList

`EASY`

**Technique:** Linked List

**Prompt:** Compare ArrayList and LinkedList and explain when each wins.

**Approach:** ArrayList is a resizable array: O(1) random access, amortized O(1) append, but O(n) insert/remove in the middle (shifting elements). LinkedList is a doubly linked list: O(1) insert/remove given an iterator/reference, but O(n) random access and worse cache locality. In practice ArrayList wins for most workloads because contiguous memory is far friendlier to the CPU cache — LinkedList is rarely the right default.

---

### How does ConcurrentHashMap achieve thread safety?

`HARD`

**Technique:** Hashing, Concurrency

**Prompt:** Explain how ConcurrentHashMap avoids locking the whole map on every operation.

**Approach:** Java 7 used segment-level locking (a fixed number of locks, each covering a slice of the table). Java 8+ dropped segments: writes synchronize only on the head node of the specific bin being modified (or use a CAS for an empty bin), so unrelated bins never block each other. Reads are largely lock-free thanks to volatile reads on the table and node fields, so they can proceed concurrently with writes and see a consistent, if possibly slightly stale, view.

---

### The equals()/hashCode() contract

`MEDIUM`

**Technique:** Hashing

**Prompt:** Why must equals() and hashCode() be overridden together, and what breaks if you don't?

**Approach:** The contract requires that two objects considered equal by equals() must return the same hashCode(). If you override only equals(), two 'equal' objects can land in different HashMap buckets — a put followed by a get with an equal-but-different-hashCode key silently fails to find the entry. Always base both methods on the same set of fields.

---

### Fail-fast vs. fail-safe iterators

`MEDIUM`

**Technique:** Concurrency

**Prompt:** What's the difference, and which Java collections use each?

**Approach:** Fail-fast iterators (ArrayList, HashMap, HashSet) track a modCount and throw ConcurrentModificationException if the collection is structurally changed while iterating, other than through the iterator itself. Fail-safe iterators (CopyOnWriteArrayList, ConcurrentHashMap) iterate over a snapshot or a weakly consistent view instead, so they never throw — but they may not reflect changes made during the iteration.

---

### How is PriorityQueue implemented?

`EASY`

**Technique:** Heap

**Prompt:** What data structure backs Java's PriorityQueue, and what are its complexity guarantees?

**Approach:** It's a binary heap stored in a plain array, with the smallest element (or highest priority, per comparator) always at index 0. offer/poll are O(log n) since they may need to sift an element up or down the tree; peek is O(1). Note the queue is only partially ordered — iterating it directly does not yield sorted order.

---

### Why is String immutable in Java?

`EASY`

**Technique:** String

**Prompt:** What does String's immutability buy the platform?

**Approach:** It enables safe sharing through the string pool/interning without defensive copies, makes String inherently thread-safe, allows the hashCode to be computed once and cached (making it a cheap, reliable HashMap key), and closes off a class of security issues where a mutable string could be changed after being validated (for example, a resource path or class name).

---

## 9. Design-Adjacent Problems

> These sit between pure DSA and system design — very common in Java/Spring backend loops because they mirror real production concerns.

### LRU Cache From Scratch

`HARD · STRETCH`

**Technique:** Hashing, Linked List, Design

**Prompt:** Implement an LRU cache without relying on LinkedHashMap, using O(1) get and put.

**Approach:** Combine a HashMap<key, Node> for O(1) lookup with a doubly linked list that keeps nodes ordered from most- to least-recently used. On access, unlink the node and relink it at the front. On a full cache, evict the node just before the tail sentinel.

**Complexity:** Time O(1) per op · Space O(capacity)

```java
class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) { this.key = key; this.value = value; }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0), tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addToFront(node);
    }

    private void moveToFront(Node node) { remove(node); addToFront(node); }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
```

---

### Rate Limiter (Token Bucket)

`MEDIUM`

**Technique:** Design, Concurrency

**Prompt:** Design a simple rate limiter that allows a fixed number of requests per second.

**Approach:** Maintain a token count that refills continuously based on elapsed time (capacity and a refill rate). Every request first tops up the bucket based on time passed, then consumes one token if available. This models bursts up to the bucket's capacity while enforcing a steady average rate.

**Complexity:** Time O(1) per check · Space O(1)

```java
class TokenBucketRateLimiter {
    private final long capacity;
    private final double refillPerNano;
    private double tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(long capacity, double refillPerSecond) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillPerNano = refillPerSecond / 1_000_000_000.0;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean tryAcquire() {
        refill();
        if (tokens >= 1) { tokens -= 1; return true; }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double added = (now - lastRefillTime) * refillPerNano;
        tokens = Math.min(capacity, tokens + added);
        lastRefillTime = now;
    }
}
```

---

### Thread-Safe Singleton

`MEDIUM`

**Technique:** Concurrency, Design

**Prompt:** Implement a singleton that is safe to initialize from multiple threads without paying a locking cost on every access.

**Approach:** Double-checked locking: only synchronize the first time the instance is created, guarded by a second null-check inside the lock so two threads can't both pass the outer check and construct two instances. The field must be volatile so the partially-constructed object is never visible to another thread. An enum with a single constant is the simplest thread-safe alternative when you don't need lazy initialization.

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

---

### Producer-Consumer with BlockingQueue

`MEDIUM`

**Technique:** Concurrency, Design

**Prompt:** Implement a producer-consumer setup using Java's concurrency utilities instead of wait()/notify().

**Approach:** BlockingQueue already handles the coordination: put() blocks when the queue is full and take() blocks when it's empty, so no manual locking is needed. This is the idiomatic Java approach — reaching for wait()/notify() directly is a signal you don't know about java.util.concurrent.

```java
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    Producer(BlockingQueue<Integer> queue) { this.queue = queue; }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) queue.put(i); // blocks if full
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    Consumer(BlockingQueue<Integer> queue) { this.queue = queue; }

    public void run() {
        try {
            while (true) {
                Integer item = queue.take(); // blocks if empty
                System.out.println("Consumed: " + item);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
```

---
