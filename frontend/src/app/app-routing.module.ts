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

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AreaAdminComponent, canActivate: [AuthGuard] },
  { path: 'oauth/token',component: LoginComponent /*resolve: { course: CourseResolver }*/ },
  { path: 'register', component: RegisterComponent },
  { path: 'products', component: ProductListComponent /*resolve: { course: CourseResolver }*/ },
  { path: 'products/:id', component: ProductDetailComponent /*resolve: { course: CourseResolver }*/ },
  { path: 'users', component: RegisterComponent /*resolve: { course: CourseResolver }*/ },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
