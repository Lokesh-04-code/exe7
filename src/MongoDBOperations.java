import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBOperations {

    public static void main(String[] args) {

        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("zipdb");

        MongoCollection<Document> collection = database.getCollection("zips");

        System.out.println("Connected to MongoDB!");

        // Send MongoDB query
        FindIterable<Document> results = collection.find(new Document("city","BOSTON"));

        // Retrieve and process results
        for(Document doc : results){
            System.out.println(doc.toJson());
        }

        mongoClient.close();
    }
}