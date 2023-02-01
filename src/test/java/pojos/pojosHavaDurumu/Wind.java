package pojos.pojosHavaDurumu;

public class Wind {

    private Float speed;
    private Integer deg;
    private Float gust;

    /**
     * No args constructor for use in serialization
     *
     */
    public Wind() {
    }

    /**
     *
     * @param deg
     * @param speed
     * @param gust
     */
    public Wind(Float speed, Integer deg, Float gust) {
        super();
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Float getGust() {
        return gust;
    }

    public void setGust(Float gust) {
        this.gust = gust;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Wind.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("speed");
        sb.append('=');
        sb.append(((this.speed == null)?"<null>":this.speed));
        sb.append(',');
        sb.append("deg");
        sb.append('=');
        sb.append(((this.deg == null)?"<null>":this.deg));
        sb.append(',');
        sb.append("gust");
        sb.append('=');
        sb.append(((this.gust == null)?"<null>":this.gust));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}