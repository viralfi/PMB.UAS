import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { VerifyComponent } from './component/verify/verify.component';
import { ResetpasswordComponent } from './component/resetpassword/resetpassword.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { ProfileComponent } from './component/profile/profile.component';
import { HomeComponent } from './component/home/home.component';
import { CustomersComponent } from './component/customers/customers.component';
import { StatsComponent } from './component/stats/stats.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import {TokenInterceptor} from "./interceptor/token.interceptor";
import { CustomerComponent } from './component/customer/customer.component';
import { NewcustomerComponent } from './component/newcustomer/newcustomer.component';
import {ExtractArrayValue} from "./pipes/extractvalue.pipe";
import {CacheInterceptor} from "./interceptor/cache.interceptor";
import {NewuserComponent} from "./component/newuser/newuser.component";
import { ProductsComponent } from './component/products/products.component';
import { NewproductComponent } from './component/newproduct/newproduct.component';
import {InvoiceComponent} from "./component/invoice/invoice.component";
import {InvoicesComponent} from "./component/invoices/invoices.component";
import {NewinvoiceComponent} from "./component/newinvoice/newinvoice.component";
import { ProductComponent } from './component/product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    VerifyComponent,
    ResetpasswordComponent,
    ProfileComponent,
    HomeComponent,
    CustomersComponent,
    StatsComponent,
    NavbarComponent,
    CustomerComponent,
    NewcustomerComponent,
    NewuserComponent,
    NewproductComponent,
    NewinvoiceComponent,
    ProductsComponent,
    InvoiceComponent,
    InvoicesComponent,
    ExtractArrayValue,
    ProductsComponent,
    ProductComponent,
    NewproductComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: CacheInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
