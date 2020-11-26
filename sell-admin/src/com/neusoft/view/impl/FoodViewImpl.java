package com.neusoft.view.impl;


import com.neusoft.dao.FoodDao;

import com.neusoft.dao.impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);
    @Override
    public void showFoodList(){
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(null);
        System.out.println("食品编号" + "\t" + "食品名称" + "\t" + "食品备注" + "\t" + "食品价格" + "\t" + "商家编号");
        for (Food f : list) {
            System.out.println(f.getFoodId() + "\t" + f.getFoodName() + "\t" +
                    f.getFoodExplain() + "\t" + f.getFoodPrice() + "\t" + f.getBusinessId());
        }
    }

    @Override
    public void saveFood(Integer businessId) {
        System.out.println("请输入新商品的编号");
        Integer foodId = input.nextInt();

        System.out.println("请输入新商品的名称");
        String foodName = input.next();

        System.out.println("请输入新商品的备注");
        String foodExcplain = input.next();

        System.out.println("请输入新商品的价格");
        Double foodPrice = input.nextDouble();

        System.out.println("请输入新商品的商家编号");
        businessId = input.nextInt();

        FoodDao dao = new FoodDaoImpl();
        Food food1 = new Food(foodId,foodName,foodExcplain,foodPrice,businessId);
        int result = dao.saveFood(food1);
        // 根据id进行查询， 然后进行回显
        if (result >0){
            System.out.println("保存成功");
            Food food =dao.getFoodById(businessId);

        }else {
            System.out.println("新建商品失败");
        }
    }
    @Override
    public void updateFood(Integer businessId) {
        System.out.println("请输入新商品的编号");
        Integer foodId = input.nextInt();

        System.out.println("请输入新商品的名称");
        String foodName = input.next();

        System.out.println("请输入新商品的备注");
        String foodExcplain = input.next();

        System.out.println("请输入新商品的价格");
        Double foodPrice = input.nextDouble();

        System.out.println("请输入新商品的商家编号");
        businessId = input.nextInt();


        //商品校验
        FoodDao dao = new FoodDaoImpl();
        Food food1 = new Food(foodId,foodName,foodExcplain,foodPrice,businessId);
        Food  food =dao.getFoodById(foodId);
        System.out.println(food);
        int res = dao.updateFood(food1);
        if(res>0){
            System.out.println("商品信息修改成功");
        }else{
            System.out.println("商品信息修改失败");
        }


    }

    @Override
    public void removeFood(Integer businessId) {
        System.out.println("请输入要删除商品id");
        int id = input.nextInt();
        FoodDao dao = new FoodDaoImpl();
        System.out.println("确认要删除吗(y/n)");
        if (input.next().equals("y")){
            int i = dao.removeFood(id);
            if (i == 1){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }
    }
}

