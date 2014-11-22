package com.oltpbenchmark.benchmarks.tpch.queries;

import com.oltpbenchmark.api.SQLStmt;

public class Q4 extends GenericQuery {

    public final SQLStmt query_stmt = new SQLStmt(
              "select "
            +     "o_orderpriority, "
            +     "count(*) as order_count "
            + "from "
            +     "orders "
            + "where "
            +     "o_orderdate >= date '1994-08-01' "
            +     "and o_orderdate < date '1994-08-01' + interval '3' month "
            +     "and exists ( "
            +         "select "
            +             "* "
            +         "from "
            +             "lineitem "
            +         "where "
            +             "l_orderkey = o_orderkey "
            +             "and l_commitdate < l_receiptdate "
            +     ") "
            + "group by "
            +     "o_orderpriority "
            + "order by "
            +     "o_orderpriority"
        );

    protected SQLStmt get_query() {
        return query_stmt;
    }
}