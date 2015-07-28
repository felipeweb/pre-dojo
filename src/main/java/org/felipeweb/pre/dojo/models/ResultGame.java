package org.felipeweb.pre.dojo.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by felipeweb on 7/27/15.
 */
public class ResultGame {
    private Long id;
    private List<Player> players = new ArrayList<>();
    private Integer totalKills = 0;

    public Integer getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(Integer totalKills) {
        this.totalKills = totalKills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        players.sort(Comparator.comparing(Player::getKills).reversed());
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Optional<Player> findPlayerByName(String name) {
        return players.stream().filter(player -> player.getName().equals(name)).findAny();
    }

    public void killsUp() {
        totalKills++;
    }
}
