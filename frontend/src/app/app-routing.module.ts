import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './authentication/login/login.component';
import { RegisterComponent } from './authentication/register/register.component';
import { AreaAdminComponent } from './ecommerce/area-admin/area-admin.component';
import { HomeComponent } from './ecommerce/home/home.component';
import { PageNotFoundComponent } from './ecommerce/page-not-found/page-not-found.component';
import { ProductListComponent } from './ecommerce/product-list/product-list.component';
import { AuthGuard } from './guards/auth.guard';
import { ProductDetailComponent } from './ecommerce/product-detail/product-detail.component';
import { ShoppingCartComponent } from './orders/shopping-cart/shopping-cart.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AreaAdminComponent, canActivate: [AuthGuard] },
  { path: 'oauth/token',component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'products', component: ProductListComponent,
  children: [
    { path: 'cart', component: ShoppingCartComponent },
    ],
  },
  { path: 'products/:id', component: ProductDetailComponent },
  { path: 'users', component: RegisterComponent },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
