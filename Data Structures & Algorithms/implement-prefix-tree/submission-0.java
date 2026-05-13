class PrefixTree {
    PrefixTree[] children;
    boolean eow;

    PrefixTree root;
    
    public PrefixTree() {
        children = new PrefixTree[26];
        for(int i=0;i<26;i++) {
            children[i] = null;
        }     
        eow = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;

        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null) {
                curr.children[index] = new PrefixTree();
            }

            curr = curr.children[index];
        }

        curr.eow = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for(int i=0;i<prefix.length();i++) {
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return true;
    }
}
