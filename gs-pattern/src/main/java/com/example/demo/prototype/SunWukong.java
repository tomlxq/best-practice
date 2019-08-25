package com.example.demo.prototype;

import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
@Data
public class SunWukong extends Monkey implements Cloneable, Serializable {
    public SunWukong() {
        System.out.println("孙悟空从石头蹦出来了！");
        this.goldenCudgel=new GoldenCudgel();
        this.setHeight(150);
        this.setWeight(30);
        this.setBirthday(new Date());
    }

    private GoldenCudgel goldenCudgel;

    /**
     * return super.clone();
     * 孙悟空从石头蹦出来了！
     * 孙悟空本尊是否一样：false
     * 孙悟空本尊生日是否一样：true
     * 孙悟空本尊金箍棒是否一样：true
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    public void change() {
        try {
            SunWukong clone = (SunWukong) clone();
            System.out.println("孙悟空本尊是否一样：" + (clone == this));
            System.out.println("孙悟空本尊生日是否一样：" + (clone.getBirthday() == this.getBirthday()));
            System.out.println("孙悟空本尊金箍棒是否一样：" + (clone.getGoldenCudgel() == this.getGoldenCudgel()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
