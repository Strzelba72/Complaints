package lab.app;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
         String status =
                client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                                "api/complaints/3/status")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Status: " + status);

        String complaints = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Complaints: " + complaints);
        String complaint = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints/3")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Complaint: " + complaint);
        String newcomplaint = "{\"id\": 3, \"complaintDate\": \"2021-04-24\", \"complaintText\": \"Repair fridge in room 311\", \"author\": \"Arthur McCoy\", \"status\": \"closed\"}";


        String putcomplaint = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints/3")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(newcomplaint, MediaType.APPLICATION_JSON), String.class);

        System.out.println("Complaint: " + newcomplaint);
        String complaintss = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Complaints: " + complaintss);

        client.close();
    }

}
