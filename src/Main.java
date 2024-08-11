import java.util.ArrayList;
import java.util.List;

class Block {
    public String previousHash;
    public String hash;
    public String data;

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.hash = calculateHash();
    }

    private String calculateHash() {
        return String.valueOf((previousHash + data).hashCode());
    }
}

    class main {
    private List<Block> blockchain = new ArrayList<>();

    public void addBlock(String data) {
        String previousHash = blockchain.isEmpty() ? "0" : blockchain.get(blockchain.size() - 1).hash;
        blockchain.add(new Block(previousHash, data));
    }

    public void displayBlockchain() {
        for (Block block : blockchain) {
            System.out.println("Block Hash: " + block.hash + ", Previous Hash: " + block.previousHash + ", Data: " + block.data);
        }
    }

    public static void main (String args[]) {
        main votingSystem = new main();
        votingSystem.addBlock("Vote1: Candidate A");
        votingSystem.addBlock("Vote2: Candidate B");
        votingSystem.displayBlockchain();
    }
}
