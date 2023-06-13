package com.example.optiondemo;

import lombok.Data;

import java.util.Optional;

/**
 * 1.Optional构造方法 Objects.requireNonNull(value)方法中value值为空，也会报NullPointerException
 * 2.of(T vlaue)方法
 * empty()方法
 * ofNullable(T value)
 * orElse，orElseGet，orElseThrow
 * flatMap(Function<? super T, Optional<U>> mapper)
 * isPresent()
 * ifPresent(Consumer<? super T> consumer)
 * filter(Predicate<? super T> predicate)
 *
 *
 * @author TomLuo
 * @date 2023年06月06日 5:14
 */@Data
 class Passenger{
    private String name;
    private String phone;
    private Address address;
    public Optional<String> getPhone(){
        return Optional.ofNullable(phone);
    }
}
@Data
class Address{
    private String province;
    private String city;
}
public class OptionDemo {
    public static void main(String[] args) {
        Passenger passenger = new Passenger();
        if (passenger.getAddress() != null){
            passenger.getAddress().getCity();
        }
       // String phone = Optional.ofNullable(passenger).map(p -> p.getPhone()).get();
        String phone = Optional.ofNullable(passenger).flatMap(p -> p.getPhone()).get();
        Optional.ofNullable(passenger).ifPresent(p -> {
            //做一些其它操作
        });
        Optional.ofNullable(passenger).filter(p -> p.getPhone().get().length()== 12);
    }
    public String getProvince(Passenger p){
        if (p != null) {
            Address address = p.getAddress();
            if (address != null) {
                String province = address.getProvince();
                if (province != null) {
                    return province;
                }
            }
        }
        throw new NullPointerException("无法找到！！！");
    }
    public String getProvince2(Passenger p){
        return Optional.ofNullable(p)
                .map(passenger -> passenger.getAddress())
                .map(address -> address.getProvince())
                .orElseThrow(() -> new NullPointerException("无法找到！！！"));
    }
}
