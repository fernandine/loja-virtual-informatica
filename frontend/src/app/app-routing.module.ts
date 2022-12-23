import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './authentication/login/login.component';
import { HomeComponent } from './ecommerce/home/home.component';
import { RegisterComponent } from './authentication/register/register.component';
import { AuthGuard } from './guards/auth.guard';
import { ProductListComponent } from './ecommerce/products/product-list/product-list.component';
import { ProductsDeactivateGuard } from './guards/products-deactivate.guard';
import { PageNotFoundComponent } from './ecommerce/page-not-found/page-not-found.component';
import { TemplateFormComponent } from './ecommerce/forms/template-form/template-form.component';
import { DataFormComponent } from './ecommerce/forms/data-form/data-form.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'auth/login', component: LoginComponent, /*resolve: { course: CourseResolver }*/ },
  { path: 'users', component: RegisterComponent, /*resolve: { course: CourseResolver }*/ },
  { path: 'products', component: ProductListComponent, canActivate: [AuthGuard] /*resolve: { course: CourseResolver }*/ },
  { path: 'templateForm', component: TemplateFormComponent },
  { path: 'dataForm', component: DataFormComponent },
  { path: 'products/:id', component: ProductListComponent, canDeactivate: [ProductsDeactivateGuard] /*resolve: { course: CourseResolver }*/ },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
