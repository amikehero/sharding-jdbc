/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.parsing.parser.statement;

import com.dangdang.ddframe.rdb.sharding.constant.SQLType;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.AggregationSelectItem;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.Condition;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.GroupBy;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.Limit;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.OrderBy;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.ShardingColumn;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.Table;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.expression.SQLExpression;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.token.SQLToken;
import com.google.common.base.Optional;

import java.util.List;

/**
 * SQL语句对象.
 *
 * @author zhangliang
 */
public interface SQLStatement {
    
    /**
     * 获取SQL语句类型.
     *
     * @return SQL语句类型
     */
    SQLType getType();
    
    /**
     * 获取表解析对象集合.
     * 
     * @return 表解析对象集合
     */
    List<Table> getTables();
    
    /**
     * 添加条件对象.
     *
     * @param condition 条件对象
     */
    void add(Condition condition);
    
    /**
     * 查找条件对象.
     *
     * @param table 表名称
     * @param column 列名称
     * @return 条件对象
     */
    Optional<Condition> find(String table, String column);
    
    /**
     * 获取列对象.
     * 
     * @param sqlExpression SQL表达式
     * @return 列对象
     */
    Optional<ShardingColumn> findColumn(SQLExpression sqlExpression);
    
    /**
     * 获取排序上下文集合.
     * 
     * @return 排序上下文集合
     */
    List<OrderBy> getOrderByList();
    
    /**
     * 获取分组上下文集合.
     * 
     * @return 分组上下文集合
     */
    List<GroupBy> getGroupByList();
    
    /**
     * 获取聚合上下文集合.
     * 
     * @return 聚合上下文集合
     */
    List<AggregationSelectItem> getAggregationSelectItems();
    
    /**
     * 获取分页上下文.
     * 
     * @return 分页上下文
     */
    Limit getLimit();
    
    /**
     * 设置分页上下文.
     *
     * @param limit  分页上下文
     */
    void setLimit(Limit limit);
    
    /**
     * 获取SQL标记集合.
     * 
     * @return SQL标记集合
     */
    List<SQLToken> getSqlTokens();
}