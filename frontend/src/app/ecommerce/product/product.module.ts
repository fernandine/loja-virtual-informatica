import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterModule } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';

import { HomeComponent } from '../home/home.component';
import { ProductDetailComponent } from '../product-detail/product-detail.component';
import { ProductListComponent } from '../product-list/product-list.component';
import { MatTableModule } from '@angular/material/table';
import { CartDetailsComponent } from '../checkout/cart-details/cart-details.component';
import { CartStatusComponent } from '../checkout/cart-status/cart-status.component';


@NgModule({
    declarations: [
        ProductDetailComponent,
        ProductListComponent,
        HomeComponent,
        CartDetailsComponent,
        CartStatusComponent
    ],
    imports: [
        CommonModule,
        NgxPaginationModule,
        MatCardModule,
        MatToolbarModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        RouterModule,
        MatTableModule,

    ]
})
export class ProductModule { }
