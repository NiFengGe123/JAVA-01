
-- 账号信息表
create table account_info(
	id             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT 					COMMENT '主键ID',
  account_id     VARCHAR(25) NOT NULL 					        					COMMENT '账号唯一ID',
	account_name   VARCHAR(20) NOT NULl 														COMMENT '账户名称',
  password			 VARCHAR(12) NOT NULl															COMMENT '账号密码',
	phone					 VARCHAR(11) NOT NULL															COMMENT '联系手机',
	from_email		 VARCHAR(250)																			COMMENT '联系邮箱',				 
	status 				 TINYINT     NOT NULL	DEFAULT	0										COMMENT '状态(-1 注销/0 待审核/1 已审核)',
  type					 TINYINT		 NOT NULL 														COMMENT '账户类型(1 买家/2 卖家)',
  create_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP 	COMMENT '创建时间',
  last_login_time datetime   																			COMMENT '最后一次登录时间',
  PRIMARY KEY	(id),
  UNIQUE 	KEY unique_account(account_id),
  INDEX 			idx_phone(phone),
  INDEX 			idx_create_time(create_time)
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT '账号信息表';

-- 商品信息表
create table product_info(
	id             	BIGINT UNSIGNED NOT NULL AUTO_INCREMENT 																		COMMENT '主键ID',
  product_id     	VARCHAR(50) NOT NULL 					        																			COMMENT '商品ID',
  product_code   	CHAR(16) 	 	NOT NULL 					        																			COMMENT '商品编码',
	product_name   	VARCHAR(20) NOT NULl 																												COMMENT '商品名称',
  bar_code			 	VARCHAR(50) NOT NULl																												COMMENT '国条码',
	price					 	DOUBLE      NOT NULL																												COMMENT '商品销售价格',
	push_status		 	TINYINT	   	NOT NULL	DEFAULT	0																							COMMENT '上架状态(0 下架/1 上架)',				 
	audit_status 	 	TINYINT    	NOT NULL	DEFAULT	0																							COMMENT '审核状态(0 待审核/1 已审核)',
  production_date datetime	 	NOT NULL 																												COMMENT '生产日期',
	shelf_life     	INT    		 	NOT NULL 																												COMMENT '商品有效日期',
  descript 				TEXT 				NOT NULL 																												COMMENT '商品描述',
  create_time    	TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP															COMMENT '创建时间',
  update_time  		TIMESTAMP  	NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	COMMENT '修改时间',
  PRIMARY KEY	(id),
  UNIQUE 	KEY unique_product(product_id),
  INDEX 			idx_product_code(product_code),
  INDEX 			idx_create_time(create_time)
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT '商品信息表';


-- 订单表
create table order_info(
	id            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT 																		COMMENT '主键ID',
  order_id     	VARCHAR(50) NOT NULL 					        																			COMMENT '订单ID',
  product_id   	VARCHAR(50) NOT NULL 					        																			COMMENT '商品ID',
	product_name  VARCHAR(20) NOT NULl 																												COMMENT '商品名称',
  product_cnt 	INT 				NOT NULl	DEFAULT 1																							COMMENT '购买数量',
	product_price	DOUBLE 			NOT NULL																												COMMENT '购买商品单价',
	fee_money 		DOUBLE			NOT NULL	DEFAULT	0.0																						COMMENT '优惠金额',				 
  create_time   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP															COMMENT '创建时间',
  update_time   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	COMMENT '修改时间',
  PRIMARY KEY	(id),
  UNIQUE 	KEY unique_order(order_id),
  INDEX 			idx_product_id(product_id),
  INDEX 			idx_create_time(create_time)
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT '订单表';

-- 订单详情表
create table order_detail(
	id             			BIGINT UNSIGNED NOT NULL AUTO_INCREMENT 																		COMMENT '主键ID',
  order_id     				VARCHAR(50)  NOT NULL 					        																		COMMENT '订单ID',
  order_no    				VARCHAR(50)  NOT NULL 					        																		COMMENT '订单编号',
	account_id   				VARCHAR(50)  NOT NULl 																											COMMENT '下单账号ID',
  shipping_user  			VARCHAR(20)  NOT NULl	DEFAULT 1																							COMMENT '收货人名称',
	address 						VARCHAR(100) NOT NULL 																											COMMENT '地址',
	payment_method 			TINYINT 		 NOT NULL 																											COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',	
	order_money 				DOUBLE 			 NOT NULL 																											COMMENT '订单金额',
	district_money 			DOUBLE 			 NOT NULL DEFAULT 0.0																						COMMENT '优惠金额',
	shipping_money 			DOUBLE 			 NOT NULL DEFAULT 0.0 																					COMMENT '运费金额',
	payment_money 			DOUBLE 			 NOT NULL DEFAULT 0.0 																					COMMENT '支付金额',
	shipping_time 			DATETIME 																																		COMMENT '发货时间',
	pay_time 						DATETIME 																																		COMMENT '支付时间',
	receive_time 				DATETIME 																																		COMMENT '收货时间',
	shipping_sn 				VARCHAR(50) 																																COMMENT '快递单号',
	shipping_comp_name 	VARCHAR(10) 																																COMMENT '快递公司名称',
	order_status 				TINYINT 		 NOT NULL DEFAULT 0 																						COMMENT '订单状态 0 未支付/1 已支付/2 已出单/3 已揽件/4 运输中/5 已到达/6 已签收',
  create_time    			TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP															COMMENT '创建时间',
  update_time  				TIMESTAMP  	 NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	COMMENT '修改时间',
  PRIMARY KEY	(id),
  UNIQUE 	KEY unique_order(order_id),
  INDEX 			idx_order_no(order_no,account_id,shipping_sn),
  INDEX 			idx_create_time(create_time)
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT '订单详情表';
