package com.example.steampunkgame.model;

public interface Enemy {

    String getName();
    int getHealth();
    int attacked(int value);
    int short_attack() throws InterruptedException;

    int charge_attack() throws InterruptedException;

    void increase_stat() throws InterruptedException;
    int pickAttack() throws InterruptedException;

    boolean healthCheck();
}
