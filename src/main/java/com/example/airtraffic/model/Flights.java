package com.example.airtraffic.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Flights_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flight_id;
    private String flight_name;
    private boolean domestic;
    private boolean status;
    private String arrivedAirport;
    private String departureAirport;
    private String departureTime;
    private String arrivalTime;
    private double ticketPrice;
    private int capacity;
    @JsonBackReference("runwayReference")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "runway_id")
    private Runway runway;
    @JsonBackReference("terminalReference")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

}