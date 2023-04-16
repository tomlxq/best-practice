package com.example.demo.facade;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class HomeTheatreFacade {
    Curtain curtain;
    DvdPlayer dvdPlayer;
    Popcorn popcorn;
    Stereo stereo;
    Projector projector;

    public HomeTheatreFacade() {
        curtain = Curtain.getInstance();
        dvdPlayer = DvdPlayer.getInstance();
        popcorn = Popcorn.getInstance();
        stereo = Stereo.getInstance();
        projector = Projector.getInstance();
    }


    public void read() {
        curtain.fell();
        popcorn.buy();
        stereo.on();
        projector.on();
        projector.adjust();
    }


    public void play() {
        dvdPlayer.play();

    }


    public void shutdown() {
        stereo.off();
        dvdPlayer.close();
        curtain.rise();
        popcorn.throwRubbish();
        projector.off();
    }
}
