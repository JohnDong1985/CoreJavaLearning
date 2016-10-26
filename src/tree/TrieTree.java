package tree;

/*
 *又称单词查找树，Trie树，是一种树形结构，是一种哈希树的变种�??
 *典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），�?以经常被搜索引擎系统用于文本词频统计�?
 *它的优点是：利用字符串的公共前缀来减少查询时间，�?大限度地减少无谓的字符串比较，查询效率比哈希树高�?
 */

/*
 *它有3个基本�?�质�?
 *根节点不包含字符，除根节点外每一个节点都只包含一个字符； 
 *从根节点到某�?节点，路径上经过的字符连接起来，为该节点对应的字符串�? 
 *每个节点的所有子节点包含的字符都不相同�??
 */

/*
 * 实现方法
 * 搜索字典项目的方法为�?
 * (1) 从根结点�?始一次搜索；
 * (2) 取得要查找关键词的第�?个字母，并根据该字母选择对应的子树并转到该子树继续进行检索；
 * (3) 在相应的子树上，取得要查找关键词的第二个字母,并进�?步�?�择对应的子树进行检索�??
 * (4) 迭代过程…�??
 * (5) 在某个结点处，关键词的所有字母已被取出，则读取附在该结点上的信息，即完成查找�?
 * 其他操作类似处理
 */
public class TrieTree {
	private int SIZE = 26;
	private TrieNode root;// 字典树的�?

	TrieTree() // 初始化字典树
	{
		root = new TrieNode();
	}

	private class TrieNode // 字典树节�?
	{
		private int num;// 有多少单词�?�过这个节点,即由根至该节点组成的字符串模式出现的次数
		private TrieNode[] son;// �?有的儿子节点
		private boolean isEnd;// 是不是最后一个节�?
		private char val;// 节点的�??

		TrieNode() {
			num = 1;
			son = new TrieNode[SIZE];
			isEnd = false;
		}
	}

	// 建立字典�?
	public void insert(String str) // 在字典树中插入一个单�?
	{
		if (str == null || str.length() == 0) {
			return;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] == null) {
				node.son[pos] = new TrieNode();
				node.son[pos].val = letters[i];
			} else {
				node.son[pos].num++;
			}
			node = node.son[pos];
		}
		node.isEnd = true;
	}

	// 计算单词前缀的数�?
	public int countPrefix(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return -1;
		}
		TrieNode node = root;
		char[] letters = prefix.toCharArray();
		for (int i = 0, len = prefix.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] == null) {
				return 0;
			} else {
				node = node.son[pos];
			}
		}
		return node.num;
	}

	// 打印指定前缀的单�?
	public String hasPrefix(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return null;
		}
		TrieNode node = root;
		char[] letters = prefix.toCharArray();
		for (int i = 0, len = prefix.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] == null) {
				return null;
			} else {
				node = node.son[pos];
			}
		}
		preTraverse(node, prefix);
		return null;
	}

	// 遍历经过此节点的单词.
	public void preTraverse(TrieNode node, String prefix) {
		if (!node.isEnd) {
			for (TrieNode child : node.son) {
				if (child != null) {
					preTraverse(child, prefix + child.val);
				}
			}
			return;
		}
		System.out.println(prefix);
	}

	// 在字典树中查找一个完全匹配的单词.
	public boolean has(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] != null) {
				node = node.son[pos];
			} else {
				return false;
			}
		}
		return node.isEnd;
	}

	// 前序遍历字典�?.
	public void preTraverse(TrieNode node) {
		if (node != null) {
			System.out.print(node.val + "-");
			for (TrieNode child : node.son) {
				preTraverse(child);
			}
		}
	}

	public TrieNode getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		TrieTree tree = new TrieTree();
		String[] strs = { "banana", "band", "bee", "absolute", "acm", };
		String[] prefix = { "ba", "b", "band", "abc", };
		for (String str : strs) {
			tree.insert(str);
		}
		System.out.println(tree.has("abc"));
		tree.preTraverse(tree.getRoot());
		System.out.println();
		// tree.printAllWords();
		for (String pre : prefix) {
			int num = tree.countPrefix(pre);
			System.out.println(pre + "" + num);
		}
	}
}
