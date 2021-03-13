-- DB0 sharding0
-- 商品信息表
create table product_info_0(
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
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT '商品信息表';


-- 商品信息表
create table product_info_1(
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
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT '商品信息表';


-- DB1 sharding1
-- 商品信息表
create table product_info_0(
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
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT '商品信息表';


-- 商品信息表
create table product_info_1(
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
)ENGINE=INNODB 	AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT '商品信息表';
