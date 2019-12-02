<body>
  <%@include file="includes/header.html" %>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
           pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page isELIgnored="false" %>
  <%@ page import="java.util.List,java.util.ArrayList" %>
  <%@ page import="com.model.*" %>
  <%! private String email; %>
  <%! private String password; %>
  <%! private String confirmPassword; %>
  <%! private City city; %>
  <%! private Race race; %>


  <%
      String login = request.getParameter("login");
      String pass = request.getParameter("pass");
      String pass2 = request.getParameter("pass2");
      String name = request.getParameter("userName");
      String country = request.getParameter("country");
      String city = request.getParameter("city");
      String street = request.getParameter("street");
      String flat = request.getParameter("flat");
      String building = request.getParameter("building");
      String gender = request.getParameter("gender");
      String comment = request.getParameter("comment");
      String agreement = request.getParameter("agree");
  %>


  <!-- MODAL REGISTATION AND LOGIN -->
  <div id="loginRegister" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"  aria-hidden="false">
      <div class="modal-dialog modal-lg">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="false">
                      '</button>
                  <h4 class="modal-title" id="loginModalLabel">
                      Login - <a href="#">lobstershop.com</a></h4>
              </div>
              <div class="modal-body">
                  <div class="row">
                      <div class="col-md" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
                          <!-- Nav tabs -->
                          <ul class="nav nav-tabs">
                              <li class="active"><a href="#Login" data-toggle="tab">Login</a></li>
                              <li><a href="#Registration" data-toggle="tab">Registration</a></li>
                          </ul>
                          <div class="tab-content">
                              <!-- LOGIN WINDOW -->
                              <div class="tab-pane active" id="Login">
                                  <form role="form" id="loginForm" class="form-horizontal" method="post">
                                      <div class="form-group">
                                          <label for="emailLogin" class="col-sm-2 control-label">
                                              Email</label>
                                          <div class="col-sm-9 input-group">
                                              <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                              <input required type="email" class="form-control" id="emailLogin" name="email" placeholder="Email" />
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="passwordLogin" class="col-sm-2 control-label">
                                              Password</label>
                                          <div class="col-sm-9 input-group">
                                              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                              <input required type="password" class="form-control" id="passwordLogin" placeholder="Password" />
                                          </div>
                                      </div>
                                      <div class="row">
                                          <div class="col-sm-2">
                                          </div>
                                          <div class="col-sm-10">
                                              <button type="submit" id="submitLogin" class="btn btn-primary btn-sm">
                                                  Submit</button>
                                          </div>
                                      </div>
                                  </form>
                              </div>
                              <!-- END LOGIN WINDOW -->
                              <!-- REGISTRATION WINDOW -->
                              <div class="tab-pane" id="Registration">
                                  <form id="registrationForm" role="form" class="form-horizontal" method="post">
                                      <div class="form-group">
                                          <label for="email" class="col-sm-3 control-label">
                                              Email</label>
                                          <div class="col-sm-9">
                                              <input required type="email" class="form-control" id="email" placeholder="Email" />
                                              <div class="status" id="statusEmail"></div>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="password" class="col-sm-3 control-label">
                                              Password</label>
                                          <div class="col-sm-9">
                                              <input required type="password" name="password" class="form-control" id="password" placeholder="Password" minlength="4" maxlength="16"/>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="passwordConfirm" class="col-sm-3 control-label">
                                              Password Confirm</label>
                                          <div class="col-sm-9">
                                              <input required type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="Enter again to validate" minlength="4" maxlength="16"/>
                                              <span id="confirmMessage" class="confirmMessage"></span>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="city" class="col-sm-3 control-label">
                                              Choose your city
                                          </label>
                                          <div class="col-sm-9">
                                              <select class="form-control selectpicker show-tick" id="city" name="city">
                                                  <option value="Winterfell">Winterfell</option>
                                                  <option value="KingsLanding">King's Landing</option>
                                                  <option value="Highgarden">Highgarden</option>
                                                  <option value="CasterlyRock">Casterly Rock</option>
                                                  <option value="Pyke">Pyke</option>
                                                  <option value="Riverrun">Riverrun</option>
                                                  <option value="Wall">The Wall and Castle Black</option>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="race" class="col-sm-3 control-label">
                                              Choose race
                                          </label>
                                          <div class="col-sm-9">
                                            <div class="custom-control custom-radio">
                                              <input type="radio" class="custom-control-input" id="human" name="race" value="human">
                                              <label class="custom-control-label" for="human">human</label>
                                              <input type="radio" class="custom-control-input" id="dragon" name="race" value="dragon">
                                              <label class="custom-control-label" for="dragon">dragon</label>
                                            </div>
                                          </div>

                                      </div>

                                      <div class="row">
                                          <div class="col-sm-2">
                                          </div>
                                          <div class="col-sm-10">
                                              <button id="submitRegister" type="submit" class="btn btn-success">
                                                  Save & Continue</button>
                                          </div>
                                      </div>
                                  </form>
                              </div>
                              <!-- END REGISTRATION WINDOW -->
                          </div>
                      </div>

                  </div>
              </div>
          </div>
      </div>
  </div>
  <!-- END MODAL REGISTATION AND LOGIN -->
  <%@include file="scripts/validate.js" %>
  <%@include file="scripts/registerAndLogin.jsp" %>
</body>
