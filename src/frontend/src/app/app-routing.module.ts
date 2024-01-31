import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CustomersComponent} from './component/customers/customers.component';
import {HomeComponent} from './component/home/home.component';
import {LoginComponent} from './component/login/login.component';
import {ProfileComponent} from './component/profile/profile.component';
import {RegisterComponent} from './component/register/register.component';
import {ResetpasswordComponent} from './component/resetpassword/resetpassword.component';
import {VerifyComponent} from './component/verify/verify.component';
import {AuthenticationGuard} from "./guard/authentication.guard";
import {NewcustomerComponent} from "./component/newcustomer/newcustomer.component";
import {CustomerComponent} from "./component/customer/customer.component";
import {NewuserComponent} from "./component/newuser/newuser.component";
import {ProductsComponent} from "./component/products/products.component";
import {NewproductComponent} from "./component/newproduct/newproduct.component";
import {InvoiceComponent} from "./component/invoice/invoice.component";
import {InvoicesComponent} from "./component/invoices/invoices.component";
import {NewinvoiceComponent} from "./component/newinvoice/newinvoice.component";
import {ProductComponent} from "./component/product/product.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'resetpassword', component: ResetpasswordComponent },
  { path: 'user/verify/account/:key', component: VerifyComponent },
  { path: 'user/verify/password/:key', component: VerifyComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthenticationGuard] },
  { path: 'customers', component: CustomersComponent, canActivate: [AuthenticationGuard] },
  { path: 'customers/new', component: NewcustomerComponent, canActivate: [AuthenticationGuard] },
  { path: 'invoices/new', component: NewinvoiceComponent, canActivate: [AuthenticationGuard] },
  { path: 'invoices', component: InvoicesComponent, canActivate: [AuthenticationGuard] },
  { path: 'users/new', component: NewuserComponent, canActivate: [AuthenticationGuard] },
  { path: 'customer/:id', component: CustomerComponent, canActivate: [AuthenticationGuard] },
  { path: 'product/:id', component: ProductComponent, canActivate: [AuthenticationGuard] },
  { path: 'invoices/:id/:invoiceNumber', component: InvoiceComponent, canActivate: [AuthenticationGuard] },
  { path: 'products', component: ProductsComponent, canActivate: [AuthenticationGuard] },
  { path: 'products/new', component: NewproductComponent, canActivate: [AuthenticationGuard] },
  { path: '', component: HomeComponent, canActivate: [AuthenticationGuard] },
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
