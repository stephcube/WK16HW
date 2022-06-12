package com.promineotech.jeep.controller.support;

public class CreateOrderTestSupport extends BaseTest{
protected String createOrderBody() {
//@formatter:off    
  String body = "{\n"
  + "  \"customer\":\"ROTH_GARTH\",\n"
  + "  \"model\":\"GRAND_CHEROKEE\",\n"
  + "  \"trim\":\"Trailhawk\",\n"
  + "  \"doors\":4,\n"
  + "  \"color\":\"EXT_DIAMOND_BLACK\",\n"
  + "  \"engine\":\"3_6_HYBRID\",\n"
  + "  \"tire\":\"LT285_GOODYEAR_OWL\",\n"
  + "  \"options\":[\n"
  + "    \"DOOR_QUAD_4\",\n"
  + "    \"EXT_AEV_LIFT\",\n"
  + "    \"EXT_WARN_WINCH\",\n"
  + "    \"EXT_WARN_BUMPER_FRONT\",\n"
  + "    \"EXT_WARN_BUMPER_REAR\",\n"
  + "    \"EXT_ARB_COMPRESSOR\"\n"
  + "  ]\n"
  + "}";
//@formatter:on
  return body;
}
}
