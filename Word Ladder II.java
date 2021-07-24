class Pair {
    String word1;
    String word2;
    Pair parent;
    
    public Pair(String word1, String word2, Pair parent){
        this.word1 = word1;
        this.word2 = word2;
        this.parent = parent;
    }
}

class Solution {
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> result = new LinkedList();
        
        boolean pathFound = false;
        int currentLevel = 0;
        
        //indexes of words that has not been used before
        List<Integer> notOperatedIndexes = new LinkedList();
        for (int i=0;i<wordList.size();i++) notOperatedIndexes.add(i);
        //indexes that were adeed to the current level and will be deleted from the notOperatedIndexes list
        HashSet<Integer> indexesToDelete = new HashSet();
        
        //pares of the current level and pares of the next level
        ArrayList<Pair> currentLevelPairs = new ArrayList();
        ArrayList<Pair> nextLevelPairs = new ArrayList();
        
        //the first pare with the begin word
        Pair firstPair = new Pair(null, beginWord, null);
        currentLevelPairs.add(firstPair);
        
        //the worst case is if the only sequence contains all the words
        while (currentLevel<wordList.size() && !pathFound){
            currentLevel++;
            
            //get the words that were not used and check if they work for the current word.
            for (Pair pair:currentLevelPairs){
                for (Integer index:notOperatedIndexes){
                    String currentWord = wordList.get(index);
                    if (numberOfDifferentCharacters(pair.word2,currentWord)!=1) continue;
                    if (currentWord.equals(endWord)) pathFound=true;
                    indexesToDelete.add(index);
                    nextLevelPairs.add(new Pair(pair.word2,currentWord,pair));
                }
            }
            
            //remove all the words that were used during this step from the pool of not used words
            for (Integer index:indexesToDelete)
                notOperatedIndexes.remove(index);
            
            currentLevelPairs = new ArrayList(nextLevelPairs);
            nextLevelPairs.clear();
            
        }
        
        //all the paths were found and are kept in pairs, in currentLevelPairs variable
        //there's need to go through them and save words in the result list.
        
        //Collect the paths
        LinkedList<String> path;
        for (Pair pair:currentLevelPairs){
            if (!pair.word2.equals(endWord)) continue; //this sequence is usefull, because doesn't contain the end word
            path = new LinkedList();
            Pair currentPair = pair;
            path.addFirst(currentPair.word2); //this is why I used a Linked list
            while(currentPair.parent!=null){
                path.addFirst(currentPair.word1);
                currentPair = currentPair.parent;
            }
            result.add(path);
        }
                
        return result;
    }
            
    private int numberOfDifferentCharacters(String string1, String string2){
        int result=0;
        char[] c1=string1.toCharArray();
        char[] c2=string2.toCharArray();
        for (int i=0;i<string1.length();i++){
            if (c1[i]!=c2[i])
                result++;
        }
        return result;
    }
}
