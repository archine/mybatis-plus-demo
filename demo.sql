CREATE TABLE "public"."company"
(
    "id" int8  NOT NULL DEFAULT nextval('company_id_seq'::regclass),
    "company_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
    "create_time"  timestamp(6),
    "update_time"  timestamp(6),
    CONSTRAINT "company_pk" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."company"
    OWNER TO "postgres";

COMMENT ON COLUMN "public"."company"."company_name" IS '公司名称';

COMMENT ON TABLE "public"."company" IS '公司';


CREATE TABLE "public"."department"
(
    "id" int8  NOT NULL DEFAULT nextval('department_id_seq'::regclass),
    "dept_name"   varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
    "create_time" timestamp(6),
    "update_time" timestamp(6),
    "company_id"  int8                                       NOT NULL,
    CONSTRAINT "department_pk" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."department"
    OWNER TO "postgres";

COMMENT ON COLUMN "public"."department"."dept_name" IS '部门名称';

COMMENT ON COLUMN "public"."department"."company_id" IS '公司id';

COMMENT ON TABLE "public"."department" IS '部门表';