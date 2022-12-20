import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { ProductFormComponent } from '../ecommerce/product-form/product-form.component';

@Injectable()
export class ProductsDeactivateGuard implements CanDeactivate<ProductFormComponent> {

  canDeactivate(component: ProductFormComponent,
     currentRoute: ActivatedRouteSnapshot,
     currentState: RouterStateSnapshot,
     nextState: RouterStateSnapshot):
   boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    throw new Error("Method not implemented.");
  }

}
