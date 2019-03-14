-- ----------------------------
一、门店基本信息表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `store` (
  `id` bigint(20) NOT NULL COMMENT '店铺修改记录id',
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '店铺名称',
  `phone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话号码',
  `address` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '店铺地址',
  `bus_stop` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公交站',
  `bus_stop_distance` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公交站距离',
  `subway_station` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地铁站',
  `subway_station_distance` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地铁站距离',
  `sale_amount` int(10) DEFAULT NULL COMMENT '总销量',
  `delivery_time` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配送时间',
  `delivery_type` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配送方式',
  `delivery_init_price` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配送起送价',
  `delivery_cost` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配送费',
  `wifi_name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'WiFi名称',
  `wifi_password` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'WiFi密码',
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '店铺简介',
  `open_time` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '营业时间',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
二、公告表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `message` (
  `id` bigint(20) NOT NULL COMMENT '公告记录id',
  `content` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公告内容',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
三、用户个人信息表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名（昵称）',
  `type` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '账号类型：0-普通账号，1-vip账号',
  `phone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `e_mail` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱号',
  `sex` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '性别：0-男，1-女',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
四、用户地址管理表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `user_address` (
  `id` bigint(20) NOT NULL COMMENT '用户地址id',
  `type` int(1) COLLATE utf8mb4_general_ci DEFAULT '3' COMMENT '地址类型：1-家，2-公司，3-学校，4-其他',
  `address` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '详细地址',
  `status` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '默认地址：0-默认，1-其他',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
五、vip账号管理表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `vip` (
  `id` bigint(20) NOT NULL COMMENT 'vip账号',
  `user_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户id',
  `level` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT 'vip等级：0-初级，1-中级，2-高级',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



-- ----------------------------
六、外卖分类表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `food_catalog` (
  `id` bigint(20) NOT NULL COMMENT '分类id',
  `name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分类名称',
  `is_have_food` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否有菜品：0-false，1-true',
  `foods` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子菜单',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
七、外卖菜品表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `food` (
  `id` bigint(20) NOT NULL COMMENT '菜单编号id',
  `food_catalog_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '外卖分类id',
  `name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜名',
  `count` int(10) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '销量',
  `price` float(6,3) COLLATE utf8mb4_general_ci DEFAULT '0.00' COMMENT '售价',
  `sale` float(6,3) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '打折幅度（根据food_catalog_id）',
  `sale_price` float(6,3) COLLATE utf8mb4_general_ci DEFAULT '0.00' COMMENT '折扣价',
  `praise` varchar(20) COLLATE utf8mb4_general_ci DEFAULT '0%' COMMENT '好评率',
  `image` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片地址',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
八、订单表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `order` (
  `id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '下单用户id',
  `admin_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单处理-管理员id',
  `cost` float(6,3) COLLATE utf8mb4_general_ci DEFAULT '0.00' COMMENT '消费金额',
  `remark` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `order_name` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '下单人',
  `order_phone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '下单号码',
  `order_address` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '下单配送地址',
  `status` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '订单状态：0-待付款，1-待发货，2-待收货，3-待评价，4-退货，5-退款，6-已完成',
  `food_sales` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '该订单包含的菜品',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
九、后台管理员信息表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `admin` (
  `id` bigint(20) NOT NULL COMMENT '管理员id',
  `name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名（昵称）',
  `type` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '账号类型：0-普通管理员，1-老板',
  `phone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `e_mail` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱号',
  `sex` int(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '性别：0-男，1-女',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
十、评价表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(20) NOT NULL COMMENT '评价id',
  `order_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单编号id',
  `user_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户id',
  `content` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '留言内容',
  `order_delivery` int(1) COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '订单配送：1-5分（满分5分）',
  `food_delicious` int(1) COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '外卖美味度：1-5分（满分5分）',
  `service_attitude` int(1) COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '客服态度：1-5分（满分5分）',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- ----------------------------
十一、菜销售表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `food_sale` (
  `id` bigint(20) NOT NULL COMMENT '菜销售id',
  `order_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单编号id',
  `food_id` bigint(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜品id',
  `food_name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜名',
  `number` int(3) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '数量',
  `pay_price` float(6,3) COLLATE utf8mb4_general_ci DEFAULT '0.00' COMMENT '支付单价（根据是否为vip显示打折菜单，支付价格根据food_catalog_id最终决定）',
  `create_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



