package com.neusoft.dao.impl;

import com.neusoft.dao.FoodDao;

import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    Connection conn=null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @Override
    public List<Food> listFoodByBusinessId(String foodName) {
        ArrayList<Food> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from food WHERE 1=1");
//
       if (foodName !=null && !foodName.equals("")){
            sql.append(" and foodName LIKE '%"+foodName+"%'");
        }
        //        System.out.println("sql ="+sql.toString());
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                list.add(food);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    @Override
    public int saveFood(Food food) {
        int result = 0;
        // 希望插入一个商家的时候自动给一个默认密码
        String sql = "insert into food(foodName,foodExplain,foodPrice,businessId) values (?,?,?,?) ";
        try {
            conn = JDBCUtils.getConnection();
            // 要设置返回自增长的键
            pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, food.getFoodName());
            pst.setString(2,food.getFoodExplain());
            pst.setDouble(3,food.getFoodPrice());
            pst.setInt(4,food.getBusinessId());
            pst.executeUpdate();
            // 同时获取自增长的id值  一行一列
            rs = pst.getGeneratedKeys();
            if (rs.next()){
                result= rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pst, conn);
        }

        return result;
    }


    @Override
    public int updateFood(Food food) {
        int result = 0;
        String sql = "update food set foodName = ?,foodExplain=? , foodPrice =?, businessId=? where foodId = ?";
        try {
            conn =  JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,food.getFoodName());
            pst.setString(2,food.getFoodExplain());
            pst.setDouble(3,food.getFoodPrice());
            pst.setInt(4,food.getBusinessId());
            pst.setInt(5,food.getFoodId());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int removeFood(Integer foodId) {
        int result = 0;
        String sql = "delete from food where foodId = ?";
        try {
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, foodId);
            result = pst.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            result = 0;
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pst, conn);
        }

        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, foodId);
            rs = pst.executeQuery();
            while (rs.next()){
                food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pst, conn);
        }
        return food;
    }
}

