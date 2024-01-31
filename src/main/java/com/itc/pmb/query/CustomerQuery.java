package com.itc.pmb.query;

public class CustomerQuery {
    public static final String STATS_QUERY =
            "SELECT c.total_customers, i.total_products, inv.total_billed " +
                    "FROM " +
                    "(SELECT COUNT(*) total_customers FROM customer) c, " +
                    "(SELECT COUNT(*) total_products FROM product) i, " +
                    "(SELECT ROUND(SUM(total)) total_billed FROM invoice) inv;";
}
