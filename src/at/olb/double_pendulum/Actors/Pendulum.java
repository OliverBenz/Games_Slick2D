package at.olb.double_pendulum.Actors;

import at.olb.double_pendulum.Interfaces.iPendulum;
import org.newdawn.slick.Graphics;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;



public class Pendulum implements iPendulum {
    private float x, y, angle, length, vel, acc, mass;

    // Mass - KG
    // Vel - m/s
    // Acc - m/s^2
    // length - m

    public Pendulum(float angle, float length, float mass, float oX, float oY){
        this.angle = angle;
        this.length = length;
        this.mass = mass;

        this.x = oX + (this.length * (float)sin(this.angle));
        this.y = oY + (this.length * (float)cos(this.angle));
    }

    @Override
    public void move(float oX, float oY, float time) {

        this.vel += time * this.acc;
        this.angle += time * this.vel;

        this.x = (oX) + (this.length * (float)sin(this.angle));
        this.y = (oY) + (this.length * (float)cos(this.angle));
    }

    @Override
    public void render(Graphics g) {
        float radius = mass / 1.2f;
        g.fillOval(this.x - (radius / 2), this.y - (radius / 2), radius, radius);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getVel() {
        return vel;
    }

    public void setVel(float vel) {
        this.vel = vel;
    }

    public float getAcc() {
        return acc;
    }

    public void setAcc(float acc) {
        this.acc = acc;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
